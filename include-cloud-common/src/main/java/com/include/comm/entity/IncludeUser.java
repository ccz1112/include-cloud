package com.include.comm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: chenshuo
 * @Date: 2022/1/12
 * @Time: 9:50
 * @version： 1.0
 * @Description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncludeUser extends BaseEntity implements Serializable {

    private Long id;

   // @NotNull(message = "请填写用户名")
    private String userName;

   // @NotNull(message = "请填写密码")
    private String password;

    private Integer age;

    private Integer sex;

    private String phone;

    private String email;

    private BigDecimal money;

    private transient List<String> roles;

    private String clientId;

    private transient List<String> permissionList;

}