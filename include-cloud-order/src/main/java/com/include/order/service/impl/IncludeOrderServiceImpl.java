package com.include.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.order.service.IIncludeOrderService;
import com.include.comm.entity.IncludeOrder;
import com.include.comm.entity.R;
import com.include.order.feign.IncludeGoodsFeignClient;
import com.include.order.mapper.IncludeOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DefaultStringRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 13:41
 * @version： 1.0
 * @Description:
 **/
@Service
@Slf4j
public class IncludeOrderServiceImpl implements IIncludeOrderService {

    private final IncludeOrderMapper includeOrderMapper;

    private RedisTemplate redisTemplate;

    @Resource
    private RestTemplate restTemplate;

    private final IncludeGoodsFeignClient includeGoodsFeignClient;

    @Autowired
    public IncludeOrderServiceImpl(IncludeOrderMapper includeOrderMapper,
                                   IncludeGoodsFeignClient includeGoodsFeignClient) {
        this.includeOrderMapper = includeOrderMapper;
        this.includeGoodsFeignClient = includeGoodsFeignClient;
    }

    @Override
    public R getList(IncludeOrder includeOrder) {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<IncludeOrder> list = includeOrderMapper.selectList(queryWrapper);
        return R.oK(list);
    }

    @Override
    public R getInfo(Integer id) {
        IncludeOrder includeOrder = includeOrderMapper.selectById(id);
        return R.oK(includeOrder);
    }

    @Override
    public R saveOrder(IncludeOrder includeOrder) {
        RedisConnection redisConnection = redisTemplate.getConnectionFactory().getConnection();
        DefaultStringRedisConnection stringRedisConnection = new DefaultStringRedisConnection(redisConnection);
        redisTemplate.setConnectionFactory(null);
        redisConnection.select(3);
        stringRedisConnection.select(3);
        log.info(">>客户下单，这时候要调用商品微服务查询商品信息");


        //通过restTemplate调用商品微服务
        R r = includeGoodsFeignClient.getInfo(includeOrder.getSkuId().intValue());
        log.info(">>商品信息，查询结果:" + JSON.toJSONString(r));
        includeOrderMapper.insert(includeOrder);

        return R.oK();
    }

    public <T> List<T> readFile(String path, Function<String,T> converter){
        List<T> result = new ArrayList<>();
        result.add(converter.apply(""));
        return result;
    }

    public void demo(){
        String path = "111";
        //this.readFile(path,IncludeOrder::converter);
    }
    public static IncludeOrder converter(String line){

        return new IncludeOrder();
    }
}