package com.example.springsecurity.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.alibaba.fastjson.JSON;
import com.example.springsecurity.config.RedisCache;
import com.example.springsecurity.response.ResponseModels;
import com.example.springsecurity.util.JwtUtil;
import com.example.springsecurity.util.WebUtil;

import io.jsonwebtoken.Claims;

/**
 * token校验以及权限校验
 * 
 * @author xu
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        // 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        String userId;
        // 解析token
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            logger.error("解析token失败");
            WebUtil.renderString(response, JSON.toJSONString(ResponseModels.loginException()));
            return;
        }
        // 从redis中获取用户信息
        String redisKey = "login:" + userId;
        LoginUser loginUser = redisCache.getCacheObject(redisKey);
        if (ObjectUtils.isEmpty(loginUser)) {
            logger.error("用户信息获取失败");
            WebUtil.renderString(response, JSON.toJSONString(ResponseModels.commonException("账户过期，请重新登录")));
            return;
        }
        String roleId = request.getHeader("role_id");
        // 校验是否有该角色
        if (!loginUser.getPermissions().contains(roleId)) {
            logger.error("角色不匹配");
            WebUtil.renderString(response, JSON.toJSONString(ResponseModels.noPowerException()));
            return;
        }
        String url = request.getRequestURI();
        String role = redisCache.getCacheObject("role:role_" + roleId);
        // 校验角色是否存在该路径
        if (!role.contains(url)) {
            logger.error("该接口路径无权限");
            WebUtil.renderString(response, JSON.toJSONString(ResponseModels.noPowerException()));
            return;
        }
        // 获取权限信息封装到Authentication中
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
        // 存入securityContextHolder
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        // 放行
        filterChain.doFilter(request, response);
    }
}
