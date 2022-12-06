package com.example.springsecurity.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.example.springsecurity.response.ResponseModels;
import com.example.springsecurity.util.WebUtil;

/**
 * 权限认证失败处理器（未使用）
 * 
 * @author xu
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
        AccessDeniedException accessDeniedException) {
        logger.error("进入到权限认证失败处理器，失败原因：{}", accessDeniedException.getLocalizedMessage());
        WebUtil.renderString(response, ResponseModels.noPowerException().toString());
    }
}
