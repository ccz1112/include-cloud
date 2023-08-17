package com.include.auth.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: chenshuo
 * @Date: 2023-03-17
 * @Time: 15:45
 * @version： 1.0
 * @Description:
 **/
@Data
public class IncludeClientDetails implements ClientDetails {


    private String clientId;
    private Set<String> resourceIds;
    private String clientSecret;
    private Set<String> clientScoped;
    private Set<String> authorizedGrantTypes;
    private Integer tokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;
    private Set<String> uri;
    private List<GrantedAuthority> authorities;

    @Override
    public String getClientId() {
        return this.clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return this.resourceIds;
    }

    @Override
    public boolean isSecretRequired() {
        return false;
    }

    @Override
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Override
    public boolean isScoped() {
        return false;
    }

    @Override
    public Set<String> getScope() {
        return this.clientScoped;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return this.uri;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return this.tokenValiditySeconds;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return this.refreshTokenValiditySeconds;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return false;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return null;
    }
}