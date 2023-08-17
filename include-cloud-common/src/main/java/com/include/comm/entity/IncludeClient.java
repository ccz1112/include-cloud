package com.include.comm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 10:56
 * @version： 1.0
 * @Description:
 **/
@Data
@TableName
public class IncludeClient extends BaseEntity{

    private String clientId;
    private String clientSecret;
    private String authorizedGrantTypes;
    private String clientScope;
    private String webServerRedirectUri;
    private String resourceIds;
    private String authorities;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String additionalInformation;
    private String autoapprove;

}