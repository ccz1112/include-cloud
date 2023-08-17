package com.include.auth.conf;

import com.include.auth.component.JwtTokenEnhancer;
import com.include.auth.service.impl.IncludeClientService;
import com.include.auth.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
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
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

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
public class AuthOauth2ServiceConfig  extends AuthorizationServerConfigurerAdapter {

    //自定义授权服务
    private final IncludeClientService includeClientService;
    //数据源配置
    private final DataSource dataSource;

    private final AuthenticationManager authenticationManager;

    private final UserServiceImpl userDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenEnhancer jwtTokenEnhancer;

    /***
     * 配置令牌端点的安全约束
     * **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()");
        security.allowFormAuthenticationForClients();

    }

    /**
     * 配置客户端详情信息
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        //DB存储模式
        //可以通过JDBC进行数据库配置
        //clients.jdbc(dataSource);
        //可自定义表名等信息,需要自己实现
        clients.withClientDetails(includeClientService);

        /***
         *   1
         * 总场次
         *  扇子  碧子  念子
         *
         * ***/
      /*  //内存存储模式
        clients.inMemory()
                //服务器标识
                .withClient("include-web")
                //客户端安全码
                .secret(passwordEncoder.encode("123456"))
                .resourceIds("")
                //授权范围
                .scopes("all")
                //允许的授权类型
                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")
                //验证回调地址
                .redirectUris("http://www.baidu.com")
                //token有效时间
                .accessTokenValiditySeconds(3600*24)
                //刷新token有效时间
                .refreshTokenValiditySeconds(3600*24*7)
                //false跳转到授权页面
                .autoApprove(false)
                .and()
                .withClient("include-app")
                .secret(passwordEncoder.encode("123456"))
                .scopes("all")
                .authorizedGrantTypes("authorization_code", "password","client_credentials","implicit","refresh_token")
                .accessTokenValiditySeconds(3600*24)
                .refreshTokenValiditySeconds(3600*24*7);*/
    }


    /**
     *配置令牌token的访问端点和令牌服务
     * **/
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //定制授权同 意页面
        //授权类型配置
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates);
        endpoints.authenticationManager(authenticationManager)//认证管理器
                .userDetailsService(userDetailsService) //配置加载用户信息的服务
                .authorizationCodeServices(AuthorizationCodeServices())//针对authorizationCode类型
                //.tokenServices(tokenService())
                .tokenStore(tokenStore())
                .tokenEnhancer(enhancerChain)
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    @Bean
    public AuthorizationCodeServices AuthorizationCodeServices(){
        //采用内存存储授权码
        return new InMemoryAuthorizationCodeServices();
    }

    public AuthorizationServerTokenServices tokenService() {

        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();

        delegates.add(accessTokenConverter());
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(includeClientService); //客户端详情服
        service.setSupportRefreshToken(true); //允许令牌自动刷新
        service.setTokenStore(tokenStore()); //令牌存储策略-内存
        service.setTokenEnhancer(enhancerChain);
        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3

        return service;
    }

    @Bean
    public TokenStore tokenStore(){
        //使用基于内存的普通令牌
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public KeyPair keyPair() {
        //从classpath下的证书中获取秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }



}