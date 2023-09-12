package com.include.auth.conf;

import com.include.auth.component.JwtTokenEnhancer;
import com.include.auth.service.impl.IncludeClientService;
import com.include.auth.service.impl.UserServiceImpl;
import com.include.comm.entity.IncludeUser;
import lombok.AllArgsConstructor;
import org.I0Itec.zkclient.Gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.*;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;
import javax.swing.*;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenshuo
 * @Date: 2023-03-27
 * @Time: 18:12
 * @version： 1.0
 * @Description:认证服务器配置核心配置
 **/
@AllArgsConstructor
@Configuration
@EnableAuthorizationServer
public class AuthOauth2ServiceConfig extends AuthorizationServerConfigurerAdapter {


    private final IncludeClientService includeClientService;

    private final JwtTokenEnhancer jwtTokenEnhancer;

    private final UserServiceImpl userService;

    private final AuthenticationManager authenticationManager;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单人证
        security.allowFormAuthenticationForClients();
    }

    //自定义服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(includeClientService);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userService) //配置加载用户信息的服务
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(enhancerChain);

    }

    public static void main(String[] args) {
     
    }
        @Bean
        public JwtAccessTokenConverter accessTokenConverter () {
            JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
            jwtAccessTokenConverter.setKeyPair(keyPair());
            return jwtAccessTokenConverter;
        }

        @Bean
        public KeyPair keyPair () {
            //从classpath下的证书中获取秘钥对
            KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
            return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
        }


    }