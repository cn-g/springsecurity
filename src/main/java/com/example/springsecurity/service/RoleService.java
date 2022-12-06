package com.example.springsecurity.service;

/**
 * @author xu
 */
public interface RoleService {

    /**
     * 将角色所属的路径访问权限存储到redis中
     */
    void saveRoleInRedis();

}
