package com.include.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 15:40
 * @version： 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}