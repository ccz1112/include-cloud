package com.include.comm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("include_order")
public class IncludeOrder {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long skuId;
    private Integer num;
    private BigDecimal price;
    private BigDecimal money;
    private Date createTime;
}