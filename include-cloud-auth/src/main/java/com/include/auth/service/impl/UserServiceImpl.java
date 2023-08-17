package com.include.auth.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.include.auth.feign.IncludeSystemFeignClient;
import com.include.comm.constatant.MessageConstant;
import com.include.comm.entity.IncludeUser;
import com.include.auth.domain.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountExpiredException;

/**
 * @author: chenshuo
 * @Date: 2023-03-01
 * @Time: 14:30
 * @version： 1.0
 * @Description:
 **/
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private IncludeSystemFeignClient includeSystemFeignClient;

    static final String Demo ="";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IncludeUser includeUser = includeSystemFeignClient.loadUserByUsername(username);
        if (ObjectUtil.isEmpty(includeUser)) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        SecurityUser securityUser = new SecurityUser(includeUser);
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!securityUser.isAccountNonExpired()) {
           // throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return securityUser;
    }

}