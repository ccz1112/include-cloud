package com.include.auth.controller;



import com.include.auth.service.OAuthTokenService;
import com.include.comm.entity.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * 自定义Oauth2获取令牌接口
 * Created by macro on 2020/7/17.
 */
@RestController
@RequestMapping("/oauth")
public class TokenController {

    @Autowired(required = false)
    private  OAuthTokenService oAuthTokenService;

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public R<?> postAccessToken(HttpServletRequest request,
                                @RequestParam @NotNull String userName) throws Exception {

        return oAuthTokenService.getToken(request,userName);
    }



}
