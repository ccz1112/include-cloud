package com.include.comm.util;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import com.alibaba.google.common.base.Stopwatch;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.include.comm.annotation.PoolDataFunction;
import com.include.comm.entity.IncludeGoodsSku;
import com.include.comm.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author: chenshuo
 * @Date: 2023-01-04
 * @Time: 15:55
 * @version： 1.0
 * @Description:
 **/
@Slf4j
@Component
public class MultithreadingDataUtils<T>{


    public List<T> limitList(){

        return null;
    }




}