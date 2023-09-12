package com.include.demo.merge;

import com.include.comm.entity.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: chenshuo
 * @Date: 2023-08-21
 * @Time: 14:15
 * @version： 1.0
 * @Description:
 **/
@RestController
@RequestMapping("merge")
public class MergeController {

    private BlockingQueue<RequestPromise> queue = new LinkedBlockingQueue<>(10);


    @RequestMapping("demo")
    public R demo() throws InterruptedException {
        if(queue.isEmpty()){
            Thread.sleep(4000);
        }
        List<RequestPromise> list = new ArrayList<>();
        int batchSize = 3;
        for (int i = 0; i < batchSize; i++) {
            list.add(queue.take());
        }
        return R.oK();
    }
}