package com.include.comm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class IncludeRole extends BaseEntity implements Serializable  {

    private Long id;

    private String roleName;


}