package com.include.chessRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 10:44
 * @version： 1.0
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Fegin
public class ChessRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessRoomApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}