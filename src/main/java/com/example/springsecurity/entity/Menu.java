package com.example.springsecurity.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author xu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class Menu {

    @TableId("id")
    private Long id;

    /**
     *菜单名
     */
    @TableField(value = "name")
    private String name;

    /**
     *路由地址
     */
    @TableField(value = "path")
    private String path;

    /**
     *组件路径
     */
    @TableField(value = "component")
    private String component;

    /**
     *菜单状态（0显示 1隐藏）
     */
    @TableField(value = "visible")
    private Integer visible;

    /**
     *菜单状态（0正常 1停用）
     */
    @TableField(value = "status")
    private Integer status;

    /**
     *权限标识
     */
    @TableField(value = "perms")
    private String perms;

    /**
     *菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     *创建人的用户id
     */
    @TableField(value = "create_by")
    private Long createBy;

    /**
     *创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     *更新人的用户id
     */
    @TableField(value = "update_by")
    private Long updateBy;

    /**
     *更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     *是否删除（0未删除 1已删除）
     */
    @TableField(value = "del_flag")
    private Integer delFlag;

    /**
     *备注
     */
    @TableField(value = "remark")
    private String remark;

}
