package com.include.goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.goods.mapper.IncludeGoodsSkuMapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author: chenshuo
 * @Date: 2023-02-27
 * @Time: 09:38
 * @version： 1.0
 * @Description:
 **/
public class QueryCallable implements Callable<List> {

    private IncludeGoodsSkuMapper includeGoodsSkuMapper;
    private int beginIndex;
    private int rows;


    public QueryCallable(IncludeGoodsSkuMapper includeGoodsSkuMapper, int beginIndex, int rows) {
        this.includeGoodsSkuMapper = includeGoodsSkuMapper;
        this.beginIndex = beginIndex;
        this.rows = rows;
    }


    @Override
    public List call() throws Exception {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.last("limit "+beginIndex+","+rows);

        return includeGoodsSkuMapper.selectList(queryWrapper);
    }
}