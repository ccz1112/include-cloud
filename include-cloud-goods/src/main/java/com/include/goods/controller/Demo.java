package com.include.goods.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.include.comm.entity.IncludeGoodsSku;
import com.include.comm.entity.R;
import com.include.comm.util.ThreadPoolUtils;
import com.include.goods.mapper.IncludeGoodsSkuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: chenshuo
 * @Date: 2023-02-24
 * @Time: 14:52
 * @version： 1.0
 * @Description:
 **/
@RestController
@Slf4j
public class Demo {


    @Autowired
    private IncludeGoodsSkuMapper includeGoodsSkuMapper;


    @RequestMapping("demo")
    public R demo(){
        ThreadPoolExecutor executor = ThreadPoolUtils.createPoolExecutor(1000, TimeUnit.MILLISECONDS, 30, "demo的线程池");

        int count = includeGoodsSkuMapper.selectCount(null);
        int num = 50;//每次查询的条数
        //需要查询的次数
        count = count / num + 1;
        //开始查询的行数
        int begIndex = 0;
        //在线程池执行之前，给计数器指定数值（与要执行代码的次数一致）
        CountDownLatch countDownLatch = new CountDownLatch(count);
        List resultList = new ArrayList();//添加任务
        for (int i = 0; i < count; i++) {
            try {
                int finalBegIndex = begIndex;

                Future<List<IncludeGoodsSku>> future = executor.submit(new Callable<List<IncludeGoodsSku>>() {
                    @Override
                    public List<IncludeGoodsSku> call() throws Exception {
                        QueryWrapper queryWrapper = new QueryWrapper();
                        queryWrapper.last("limit " + finalBegIndex + "," + num);
                        return includeGoodsSkuMapper.selectList(queryWrapper);
                    }
                });
                begIndex = begIndex + num;
                resultList.addAll(future.get());
            } catch (Exception e) {
                log.error("Exception=={}", e);
            } finally {
                countDownLatch.countDown();
            }
        }
        try {
            //等待计数器归零
            countDownLatch.await();
            executor.shutdown();  // 关闭线程池
        } catch (Exception e) {
            log.error("Exception=={}", e);
        }
        return R.oK(resultList.size());
    }


    @RequestMapping("notTaskDemo")
    public R notTaskDemo() {

        long start = System.currentTimeMillis();

        int count = includeGoodsSkuMapper.selectCount(null);

        int num = 50;//每次查询的条数
        //需要查询的次数
        int times = count / num;
        if (count % num != 0) {
            times = times + 1;
        }
        //开始查询的行数
        int bindex = 0;

        List tasks = new ArrayList<Callable<List>>();//添加任务
        for (int i = 0; i < times; i++) {

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.last("limit " + bindex + "," + num);
            bindex = bindex + num;
            List list = includeGoodsSkuMapper.selectList(queryWrapper);
            tasks.addAll(list);
        }

        long end = System.currentTimeMillis();
        log.info("用时" + (start - end));
        return R.oK();
    }
}

