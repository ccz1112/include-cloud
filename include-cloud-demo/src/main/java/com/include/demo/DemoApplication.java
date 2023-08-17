package com.include.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: chenshuo
 * @Date: 2023-05-16
 * @Time: 16:30
 * @version： 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.include"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}