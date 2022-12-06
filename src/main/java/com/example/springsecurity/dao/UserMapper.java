package com.example.springsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Admin
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
