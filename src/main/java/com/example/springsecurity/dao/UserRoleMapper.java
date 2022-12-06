package com.example.springsecurity.dao;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity.entity.UserRole;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {}
