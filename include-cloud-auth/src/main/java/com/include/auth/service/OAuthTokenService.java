package com.include.auth.service;

import com.include.comm.entity.R;

import javax.servlet.http.HttpServletRequest;

/**
 * @projectName include-cloud-common
 * @packageName com.include.auth.service.impl
 * @className ITokenService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2023-04-20 10:45
 */
public interface OAuthTokenService {

    R<?> getToken(HttpServletRequest request,String userName);
}
