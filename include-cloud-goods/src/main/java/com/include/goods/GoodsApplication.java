package com.include.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 10:45
 * @version： 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

}