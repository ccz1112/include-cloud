package com.include.comm.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 10:56
 * @version： 1.0
 * @Description:
 **/
@Data
@TableName
public class IncludeGoodsSku {

    private Long id;
    private BigDecimal price;
    private String title;
    private String url;
    private String photo;
    private Date createTime;
}