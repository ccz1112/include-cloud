package com.include.auth.service.impl;

import com.include.auth.domain.Oauth2TokenDto;
import com.include.auth.feign.IncludeSystemFeignClient;

import com.include.auth.service.OAuthTokenService;
import com.include.comm.constatant.AuthConstant;
import com.include.comm.entity.IncludeUser;
import com.include.comm.entity.R;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author: chenshuo
 * @Date: 2023-04-20
 * @Time: 10:45
 * @version： 1.0
 * @Description:
 **/
@Service("oAuthTokenService")
@AllArgsConstructor
public class OAuthTokenServiceImpl implements OAuthTokenService {

    private final IncludeSystemFeignClient includeSystemFeignClient;

    private final IncludeClientService includeClientService;

    private final TokenEndpoint tokenEndpoint;

    private final PasswordEncoder passwordEncoder;

    @Override
    public R<?> getToken(HttpServletRequest request,String userName) {
        IncludeUser includeUser = includeSystemFeignClient.loadUserByUsername(userName);
        ClientDetails clientDetails = includeClientService.loadClientByClientId(includeUser.getClientId());
        //passwordEncoder.upgradeEncoding();
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type","password");
        parameters.put("client_id",clientDetails.getClientId());
        parameters.put("client_secret","123456");
        //parameters.putIfAbsent("refresh_token",refresh_token);
        parameters.putIfAbsent("username",includeUser.getUserName());
        parameters.putIfAbsent("password",includeUser.getPassword());
        //parameters.put("code",code);
        OAuth2AccessToken oAuth2AccessToken = null;
        try {
            oAuth2AccessToken = tokenEndpoint.postAccessToken(request.getUserPrincipal(), parameters).getBody();
            oAuth2AccessToken = Optional.ofNullable(oAuth2AccessToken).orElseThrow(Exception::new);
            Oauth2TokenDto oauth2TokenDto = Oauth2TokenDto.builder()
                    .token(oAuth2AccessToken.getValue())
                    .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                    .expiresIn(oAuth2AccessToken.getExpiresIn())
                    .tokenHead(AuthConstant.JWT_TOKEN_PREFIX).build();
            return R.oK(oauth2TokenDto);
        } catch (HttpRequestMethodNotSupportedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return R.error();
    }
}