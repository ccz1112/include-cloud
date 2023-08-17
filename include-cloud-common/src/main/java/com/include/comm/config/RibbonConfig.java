package com.include.comm.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: chenshuo
 * @Date: 2022-11-22
 * @Time: 14:55
 * @version： 1.0
 * @Description:
 **/
@Configuration
public class RibbonConfig {

    @Bean
    @LoadBalanced
    public IRule rule(){
        return new RandomRule();
    }
}