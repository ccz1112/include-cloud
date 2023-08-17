package com.include.auth.component;

import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: chenshuo
 * @Date: 2023-03-22
 * @Time: 19:06
 * @version： 1.0
 * @Description:
 **/
@Component
public class AuthorizationCodeComponent implements AuthorizationCodeServices {

    protected final ConcurrentHashMap<String, OAuth2Authentication> authorizationCodeStore = new ConcurrentHashMap();
    // 生成随机字符的类
    private RandomValueStringGenerator generator = new RandomValueStringGenerator(10);

    /**
     * @description 生成授权码的方法
     * @param: [oAuth2Authentication]
     * @return: java.lang.String
     */
    @Override
    public String createAuthorizationCode(OAuth2Authentication oAuth2Authentication) {
        String code = this.generator.generate();
        authorizationCodeStore.put(code, oAuth2Authentication);
        return code;
    }

    /**
     * @description
     * @param: [code]
     * @return: org.springframework.security.oauth2.provider.OAuth2Authentication
     */
    @Override
    public OAuth2Authentication consumeAuthorizationCode(String code) throws InvalidGrantException {
        OAuth2Authentication authentication = authorizationCodeStore.remove(code);
        return authentication;
    }
}