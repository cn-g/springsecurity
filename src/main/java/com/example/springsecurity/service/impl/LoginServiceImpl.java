package com.example.springsecurity.service.impl;

import java.time.LocalDate;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.springsecurity.config.RedisCache;
import com.example.springsecurity.dao.UserMapper;
import com.example.springsecurity.dao.UserRoleMapper;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.entity.UserRole;
import com.example.springsecurity.filter.LoginUser;
import com.example.springsecurity.response.CommonException;
import com.example.springsecurity.response.ResponseModelDto;
import com.example.springsecurity.response.ResponseModels;
import com.example.springsecurity.service.LoginService;
import com.example.springsecurity.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 登录登出实现类
 * 
 * @author xu
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    private final static Long roleId = 2L;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisCache redisCache;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseModelDto login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if (ObjectUtils.isEmpty(authentication)) {
            throw new CommonException("用户名或密码错误");
        }
        log.info("用户登录成功：{}", authentication);
        // 使用userId生成token
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject("login:" + userId, loginUser);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return ResponseModels.ok(map);
    }

    @Override
    public ResponseModelDto logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + userId);
        return ResponseModels.ok("登出成功");
    }

    @Override
    public Boolean register(User user) {
        log.info("存储的信息为：{}", SecurityContextHolder.getContext().getAuthentication().getDetails());
        // 密码加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreateTime(LocalDate.now());
        user.setDelFlag(0);
        user.setStatus(0);
        user.setUserType(1);
        userMapper.insert(user);
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(roleId);
        userRoleMapper.insert(userRole);
        return true;
    }

}
