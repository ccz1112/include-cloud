package com.include.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.comm.entity.IncludeGoodsSku;
import com.include.comm.entity.R;
import com.include.comm.util.ThreadPoolUtils;
import com.include.goods.mapper.IncludeGoodsSkuMapper;
import com.include.goods.service.IIncludeGoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 11:43
 * @version： 1.0
 * @Description:
 **/
@Service
@Slf4j
public class IncludeGoodsServiceImpl implements IIncludeGoodsService {


    private final IncludeGoodsSkuMapper includeGoodsSkuMapper;

    @Autowired
    public IncludeGoodsServiceImpl(IncludeGoodsSkuMapper includeGoodsSkuMapper) {
        this.includeGoodsSkuMapper = includeGoodsSkuMapper;
    }

    @Override
    public R getList(IncludeGoodsSku includeGoodsSku) {
        //QueryWrapper queryWrapper = new QueryWrapper();
        //List<IncludeGoodsSku> list = includeGoodsSkuMapper.selectList(queryWrapper);

        return getThreadPool(3472);
    }

    @Override
    public R getInfo(Integer id) {
        IncludeGoodsSku includeGoodsSku = includeGoodsSkuMapper.selectById(id);
        return R.oK(includeGoodsSku);
    }


    public static void main(String[] args) {
        Stream<String> stream = Stream.of("12","34","66");
        stream.forEach(res->System.out.println(res));

    }

    private R getThreadPool(int count){
        StopWatch watch = new StopWatch();

        ThreadPoolExecutor poolExecutor = ThreadPoolUtils.createPoolExecutor( 1000, TimeUnit.MILLISECONDS, 30, "httpUtils");


        //循环次数
        int cycles = count / 300;
        int lastFinalEnd = count%300;
        watch.start();
        List<IncludeGoodsSku> list = new ArrayList<>();

        try {
            for (int i = 0; i < cycles+1; i++) {
                AtomicInteger finalEnd = new AtomicInteger(300);
                int finalStart = i;
                log.info("i=={}",i);
                if(i==cycles){
                    //finalEnd = lastFinalEnd;
                    finalEnd = new AtomicInteger(lastFinalEnd);
                }

                AtomicInteger finalEnd1 = finalEnd;
                //poolExecutor.execute();
                poolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        log.info("finalStart=={}"+finalStart,"finalEnd1=={}"+finalEnd1);
                        QueryWrapper<IncludeGoodsSku> queryWrapper = new QueryWrapper();
                        queryWrapper.last(" limit "+finalStart+","+ finalEnd1);
                        List<IncludeGoodsSku> callList = includeGoodsSkuMapper.selectList(queryWrapper);
                        list.addAll(callList);
                    }
                });
            }
            watch.stop();
            //这里先执行后,线程池的isTerminated才有可能会变成true
            poolExecutor.shutdown();
            while (!poolExecutor.isTerminated()){
                if(poolExecutor.isTerminated()){
                    break;
                }
            }
            log.info("查询总量耗时{}", watch.getTotalTimeMillis());
            log.info("list=={}",list.size());
            Set set = list.stream().collect(Collectors.toSet());
            log.info("set=={}",set.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdownNow();
        }
        return R.oK(list);
    }
}