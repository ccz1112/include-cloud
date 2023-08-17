package com.include.auth.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;

/**
 * @author: chenshuo
 * @Date: 2023-04-19
 * @Time: 14:57
 * @version： 1.0
 * @Description:
 **/
@SessionAttributes({AuthCodeController.AUTHORIZATION_REQUEST_ATTR_NAME})
@Controller
public class AuthCodeController {

    static final String AUTHORIZATION_REQUEST_ATTR_NAME = "authorizationRequest";

    private AuthorizationEndpoint authorizationEndpoint;
    private AuthorizationCodeServices authorizationCodeServices = new InMemoryAuthorizationCodeServices();
    @RequestMapping(value = "/oauth/authorize")
    public String authorize(Map<String, Object> model, @RequestParam Map<String, String> parameters,
                                  SessionStatus sessionStatus, Principal principal) {
        try {


        }catch (Exception e){

        }
        return null;
    }
}