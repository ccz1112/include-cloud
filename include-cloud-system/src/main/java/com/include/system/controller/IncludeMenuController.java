package com.include.system.controller;

import com.alibaba.fastjson.JSON;
import com.include.comm.entity.IncludeMenu;
import com.include.comm.entity.R;
import com.include.system.service.IIncludeMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ author: 陈硕
 * @ Date: 2022-12-13
 * @ Time: 14:12
 * @ version： 1.0
 * @ Description:
 **/
@RestController
@RequestMapping("includeMenu")
@Slf4j
public class IncludeMenuController {

    private final IIncludeMenuService includeMenuService;

    public IncludeMenuController(IIncludeMenuService includeMenuService) {
        this.includeMenuService = includeMenuService;
    }

    @PostMapping("getMenuList")
    public R<?> getMenuList(@RequestBody IncludeMenu includeMenu){
        log.info(" getMenuList data = {}", JSON.toJSONString(includeMenu));
        return includeMenuService.menuList(includeMenu);
    }

    @PostMapping("saveMenu")
    public R<?> saveMenu(@RequestBody IncludeMenu includeMenu){
        log.info(" saveMenu data = {}", JSON.toJSONString(includeMenu));
        return includeMenuService.saveMenu(includeMenu);
    }

    @PostMapping("updateMenu")
    public R<?> updateMenu(@RequestBody IncludeMenu includeMenu){
        log.info(" updateMenu data = {}", JSON.toJSONString(includeMenu));
        return includeMenuService.updateMenu(includeMenu);
    }
    @PostMapping("getInfo")
    public R<?> getInfo(Long id){
        return includeMenuService.menuInfo(id);
    }

    @PostMapping("bindingRoleMenu")
    public R<?> bindingRoleMenu(){
        return includeMenuService.bindingRoleMenu();
    }
}