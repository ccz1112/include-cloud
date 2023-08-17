package com.include.comm.util;

import cn.hutool.core.convert.Convert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author: chenshuo
 * @Date: 2023-03-01
 * @Time: 14:58
 * @version： 1.0
 * @Description:
 **/
public class LoginUserHolder {

    /*public UserDTO getCurrentUser(){
        //从Header中获取用户信息
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String userStr = request.getHeader("user");
        JSONObject userJsonObject = new JSONObject(userStr);
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userJsonObject.getStr("user_name"));
        userDTO.setId(Convert.toLong(userJsonObject.get("id")));
        userDTO.setRoles(Convert.toList(String.class,userJsonObject.get("authorities")));
        return userDTO;
    }*/
}