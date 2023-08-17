/*
package com.include.auth.conf;


import com.include.auth.component.AuthorizationCodeComponent;
import com.include.auth.component.JwtTokenEnhancer;
import com.include.auth.service.impl.IncludeClientService;
import com.include.auth.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Configuration
@EnableAuthorizationServer
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserServiceImpl userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenEnhancer jwtTokenEnhancer;
    private final IncludeClientService includeClientService;
    private final DataSource dataSource;
    private final AuthorizationCodeComponent authorizationCodeComponent;



    //默认为2个客户端,后期可以通过db方式配置各个客户端之间的响应参数
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //DB存储模式
        //可以通过JDBC进行数据库配置
        //clients.jdbc(dataSource);
        //可自定义表名等信息,需要自己实现
        clients.withClientDetails(includeClientService);

        //内存存储模式
 clients.inMemory()
                //服务器标识
                .withClient("include-web")
                //客户端安全码
                .secret(passwordEncoder.encode("123456"))
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
                .refreshTokenValiditySeconds(3600*24*7);

    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //授权类型配置
        TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
        List<TokenEnhancer> delegates = new ArrayList<>();
        delegates.add(jwtTokenEnhancer);
        delegates.add(accessTokenConverter());
        enhancerChain.setTokenEnhancers(delegates); //配置JWT的内容增强器
        endpoints.authenticationManager(authenticationManager)//认证管理器
                .userDetailsService(userDetailsService) //配置加载用户信息的服务
                .authorizationCodeServices(AuthorizationCodeServices())//针对authorizationCode类型
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(enhancerChain);

    }


    @Bean
    public AuthorizationCodeServices AuthorizationCodeServices(){
        InMemoryAuthorizationCodeServices memoryAuthorizationCodeServices = new InMemoryAuthorizationCodeServices();
        return memoryAuthorizationCodeServices;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()");
        security.allowFormAuthenticationForClients();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setKeyPair(keyPair());
        return jwtAccessTokenConverter;
    }

    @Bean
    public KeyPair keyPair() {
        //从classpath下的证书中获取秘钥对
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "123456".toCharArray());
        return keyStoreKeyFactory.getKeyPair("jwt", "123456".toCharArray());
    }

}
*/
