package com.example.springsecurity.support.schedduler;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.springsecurity.service.RoleService;

import lombok.extern.slf4j.Slf4j;

/**
 * 定时任务
 * 
 * @author xu
 */
@Configuration // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling // 2.开启定时任务
@Slf4j
public class RoleJob {

    @Resource
    private RoleService roleService;

    @Scheduled(cron = "0 0 1 * * *")
    private void insertRoleInRedis() {
        log.info("-------------开始执行定时任务------------");
        roleService.saveRoleInRedis();
        log.info("-------------执行定时任务完毕------------");
    }

}
