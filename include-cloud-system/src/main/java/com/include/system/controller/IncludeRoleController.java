package com.include.system.controller;

import com.alibaba.fastjson.JSON;
import com.include.comm.entity.IncludeRole;
import com.include.comm.entity.R;
import com.include.system.service.IIncludeRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ author: 陈硕
 * @ Date: 2022-12-13
 * @ Time: 14:12
 * @ version： 1.0
 * @ Description:
 **/
@RestController
@RequestMapping("includeRole")
@Slf4j
public class IncludeRoleController {


    private final IIncludeRoleService iIncludeRoleService;

    public IncludeRoleController(IIncludeRoleService iIncludeRoleService) {
        this.iIncludeRoleService = iIncludeRoleService;
    }

    @PostMapping("insertRole")
    public R<?> insertRole(@RequestBody IncludeRole role){
        log.info("insertRole data = {}", JSON.toJSONString(role));
        return iIncludeRoleService.insertRole(role);
    }

    @PostMapping("roleList")
    public R<?> roleList(@RequestBody IncludeRole role){
        log.info("roleList data = {}", JSON.toJSONString(role));
        return iIncludeRoleService.roleList(role);
    }

    @PostMapping("updateRole")
    public R<?> updateRole(@RequestBody IncludeRole role){
        log.info("updateRole data = {}", JSON.toJSONString(role));
        return iIncludeRoleService.updateRole(role);
    }

    @PostMapping("deleteRole")
    public R<?> deleteRole(Long id){
        log.info("deleteRole data = {}", id);
        return iIncludeRoleService.deleteRole(id);
    }

    @PostMapping("roleInfo")
    public R<?> roleInfo(Long id){
        log.info("roleInfo data = {}", id);
        return iIncludeRoleService.roleInfo(id);
    }

}