package com.example.springsecurity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springsecurity.dto.RoleUrlDto;
import com.example.springsecurity.entity.Role;

/**
 * @author xu
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 获取用户的角色
     * 
     * @param userId 角色id
     */
    List<String> selectRoleByUserId(@Param("userId") Long userId);

    /**
     * 查询所有角色对应的路径
     *
     */
    List<RoleUrlDto> selectRoleUrl();
}
