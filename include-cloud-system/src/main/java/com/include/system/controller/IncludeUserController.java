package com.include.system.controller;

import com.alibaba.fastjson.JSON;
import com.include.comm.entity.IncludeUser;
import com.include.comm.entity.R;
import com.include.system.service.IIncludeUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/***
 * @ author: 陈硕
 * @ Date: 2022-12-13
 * @ Time: 14:12
 * @ version： 1.0
 * @ Description:
 ***/

@RestController
@RequestMapping("includeUser")
@Slf4j
public class IncludeUserController {

    private final IIncludeUserService includeUserService;

    public IncludeUserController(IIncludeUserService includeUserService) {
        this.includeUserService = includeUserService;
    }


    @PostMapping("login")
    public R<?> login(@RequestBody IncludeUser includeUser){
        log.info("login data = {}", JSON.toJSONString(includeUser));
        return includeUserService.login(includeUser);
    }

    @PostMapping("loadUserByUsername")
    public IncludeUser loadUserByUsername(@RequestParam("userName") String userName){
        log.info("loadUserByUsername data = {}", userName);
        return includeUserService.loadUserByUsername(userName);
    }

    @PostMapping("IncludeUserGetInfo")
    public R<?> IncludeUserGetInfo(@RequestParam("userId") Long userId){
        log.info("IncludeUserGetInfo data = {}", userId);
        return includeUserService.getInfo(userId);
    }

    @PostMapping("IncludeUserSave")
    public R<?> IncludeUserSave(@RequestBody IncludeUser includeUser){
        log.info("IncludeUserSave data = {}", includeUser);
        return includeUserService.save(includeUser);
    }

    @PostMapping("IncludeUserUpdate")
    public R<?>  IncludeUserUpdate(@RequestBody IncludeUser includeUser){
        log.info("IncludeUserUpdate data = {}", includeUser);
        return includeUserService.update(includeUser);
    }

    @PostMapping("IncludeUserDelete")
    public R<?> IncludeUserDelete(@RequestParam("userId") Long userId){
        log.info("IncludeUserDelete data = {}", userId);
        return includeUserService.delete(userId);
    }

}
