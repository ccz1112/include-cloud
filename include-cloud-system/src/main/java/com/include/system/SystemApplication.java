package com.include.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ author: chenshuo
 * @ Date: 2022-11-15
 * @ Time: 17:48
 * @ version： 1.0
 * @ Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.include"})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
    }


}