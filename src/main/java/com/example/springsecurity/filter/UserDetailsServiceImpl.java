package com.example.springsecurity.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.springsecurity.dao.RoleMapper;
import com.example.springsecurity.dao.UserMapper;
import com.example.springsecurity.entity.User;

import lombok.extern.slf4j.Slf4j;

/**
 * UserDetailsService实现类
 * 
 * @author xu
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        log.info("用户名称为:{}", userName);
        User user = userMapper
            .selectOne(Wrappers.lambdaQuery(User.class).eq(User::getUsername, userName).eq(User::getStatus, 0));
        if (ObjectUtils.isEmpty(user)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 获取当前用户角色信息
        List<String> list = roleMapper.selectRoleByUserId(user.getId());
        log.info("用户的角色为：{}", list);
        return new LoginUser(user, list);
    }
}
