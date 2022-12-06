package com.example.springsecurity.service;

import com.example.springsecurity.entity.User;
import com.example.springsecurity.response.ResponseModelDto;

/**
 * @author xu
 */
public interface LoginService {

    /**
     * 登录
     * 
     * @param user
     * @return
     */
    ResponseModelDto login(User user);

    /**
     * 登出
     * 
     * @return
     */
    ResponseModelDto logout();

    /**
     * 注册
     * 
     * @param user
     * @return
     */
    Boolean register(User user);

}
