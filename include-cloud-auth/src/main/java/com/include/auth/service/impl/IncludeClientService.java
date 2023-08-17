package com.include.auth.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.include.auth.domain.IncludeClientDetails;
import com.include.auth.mapper.IncludeClientMapper;
import com.include.comm.entity.IncludeClient;
import com.include.comm.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.*;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chenshuo
 * @Date: 2023-03-17
 * @Time: 14:22
 * @version： 1.0
 * @Description:
 **/
@Service
@Slf4j
public class IncludeClientService implements ClientDetailsService, ClientRegistrationService {

    @Autowired
    private IncludeClientMapper includeClientMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        IncludeClient includeClient = null;

        IncludeClientDetails clientDetails = new IncludeClientDetails();

        String val = redisTemplate.opsForValue().get(clientId);

        //DB查询
        if(val==null){
            LambdaQueryWrapper<IncludeClient> lambdaQuery = Wrappers.lambdaQuery();
            lambdaQuery.eq(IncludeClient::getClientId,clientId);
            includeClient  = includeClientMapper.selectOne(lambdaQuery);
            if(includeClient==null){
                log.error("服务尚未配置");
                throw new BusinessException(40100000,"服务尚未配置");
            }
            redisTemplate.opsForValue().set(clientId,JSON.toJSONString(includeClient));
        }else{
            includeClient = JSON.parseObject(val,IncludeClient.class);
        }




        //Set <String> ids = Arrays.stream(includeClient.getResourceIds().split(",")).collect(Collectors.toSet());
        Set <String> scope = Arrays.stream(includeClient.getClientScope().split(",")).collect(Collectors.toSet());
        Set <String> grantTypes = Arrays.stream(includeClient.getAuthorizedGrantTypes().split(",")).collect(Collectors.toSet());
        Set <String> uri = Arrays.stream(includeClient.getWebServerRedirectUri().split(",")).collect(Collectors.toSet());
        //userDto.getRoles().forEach(item -> grantedAuthority.ad(new SimpleGrantedAuthority(item)));

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        //authorities.add(new SimpleGrantedAuthority("READ"));
        //authorities.add(new SimpleGrantedAuthority("WRITE"));

        clientDetails.setClientId(includeClient.getClientId());
        //clientDetails.setResourceIds(ids);
        clientDetails.setClientScoped(scope);
        clientDetails.setClientSecret(includeClient.getClientSecret());
        clientDetails.setAuthorizedGrantTypes(grantTypes);
        clientDetails.setTokenValiditySeconds(includeClient.getAccessTokenValidity());
        clientDetails.setRefreshTokenValiditySeconds(includeClient.getRefreshTokenValidity());
        clientDetails.setUri(uri);
        clientDetails.setAuthorities(authorities);
        return clientDetails;

    }

    @Override
    public void addClientDetails(ClientDetails clientDetails) throws ClientAlreadyExistsException {

    }

    @Override
    public void updateClientDetails(ClientDetails clientDetails) throws NoSuchClientException {

    }

    @Override
    public void updateClientSecret(String clientId, String secret) throws NoSuchClientException {

    }

    @Override
    public void removeClientDetails(String clientId) throws NoSuchClientException {

    }

    @Override
    public List<ClientDetails> listClientDetails() {
        return null;
    }
}