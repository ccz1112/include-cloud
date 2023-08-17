package com.include.comm.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

/**
 * @author: chenshuo
 * @Date: 2022-12-13
 * @Time: 16:06
 * @version： 1.0
 * @Description:
 **/
public class BaseEntity {

    @TableField(fill = FieldFill.INSERT) //固定字段，用于管理表
    private Date createTime;

    @TableField(fill = FieldFill.INSERT) //固定字段，用于管理表
    private String createBy;

    @TableField(fill = FieldFill.INSERT_UPDATE) //固定字段，用于管理表
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) //固定字段，用于管理表
    private String updateBy;

    private transient Integer count;

    private transient Integer pageSize;

    private transient Integer pageNum;
}