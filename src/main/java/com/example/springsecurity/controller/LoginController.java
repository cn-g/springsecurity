package com.example.springsecurity.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.response.ResponseModelDto;
import com.example.springsecurity.response.ResponseModels;
import com.example.springsecurity.service.LoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * 登陆相关
 * 
 * @author xu
 */
@RestController
@Slf4j
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseModelDto login(@RequestBody User user) {
        log.info("接收到用户名{}", user.getUsername());
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseModelDto logout() {
        return loginService.logout();
    }

    @PostMapping("/user/register")
    public ResponseModelDto register(@RequestBody User user) {
        return ResponseModels.ok(loginService.register(user));
    }

}
