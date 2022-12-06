package com.example.springsecurity.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.example.springsecurity.response.ResponseModels;
import com.example.springsecurity.util.WebUtil;

/**
 * 登录认证失败处理器
 * 
 * @author xu
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException authException) {
        logger.error("进入到认证失败处理器,失败原因:{}", authException.getLocalizedMessage());
        WebUtil.renderString(response, JSON.toJSONString(ResponseModels.loginException()));
    }
}
