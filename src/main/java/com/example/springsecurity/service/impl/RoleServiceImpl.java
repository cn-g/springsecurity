package com.example.springsecurity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.springsecurity.config.RedisCache;
import com.example.springsecurity.dao.RoleMapper;
import com.example.springsecurity.dto.RoleUrlDto;
import com.example.springsecurity.service.RoleService;

/**
 * 权限实现类
 * 
 * @author xu
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final static String role = "role:role_";

    @Resource
    private RoleMapper roleMapper;

    @Resource
    RedisCache redisCache;

    @Override
    public void saveRoleInRedis() {
        List<RoleUrlDto> roleList = roleMapper.selectRoleUrl();
        roleList.forEach(r -> {
            redisCache.setCacheObject(role + r.getRoleId(), r.getPath());
        });
    }
}
