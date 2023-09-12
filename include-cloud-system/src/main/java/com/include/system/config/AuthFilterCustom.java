/*
package com.include.system.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

*/
/**
 * @author: chenshuo
 * @Date: 2023-08-25
 * @Time: 13:52
 * @version： 1.0
 * @Description:
 **//*

@Slf4j
@Component
public class AuthFilterCustom extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String tokenInfo=request.getHeader("token-info");
        if(StringUtils.isEmpty(tokenInfo)){
            log.info("未找到token信息");
            filterChain.doFilter(request,response);
            return;
        }
        JwtTokenInfo jwtTokenInfo = objectMapper.readValue(tokenInfo, JwtTokenInfo.class);
        log.info("tokenInfo={}",objectMapper.writeValueAsString(jwtTokenInfo));
        List<String> authorities1 = jwtTokenInfo.getAuthorities();
        String[] authorities=new String[authorities1.size()];
        authorities1.toArray(authorities);
        //将用户信息和权限填充 到用户身份token对象中
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(jwtTokenInfo.getUser_name(),null, AuthorityUtils.createAuthorityList(authorities));
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        //将authenticationToken填充到安全上下文
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}*/
