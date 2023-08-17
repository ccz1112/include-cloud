package com.include.comm.util;

import lombok.Data;

import java.util.List;

/**
 * @author: chenshuo
 * @Date: 2023-02-28
 * @Time: 14:46
 * @version： 1.0
 * @Description:分页工具类
 **/
@Data
public class PageUtils<T> {

    private Integer total;

    private Integer pageSize;

    private Integer pageNum;

    private List<T> rows;

    public PageUtils(Integer pageSize, Integer pageNum) {
        this.total = rows.size();
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}