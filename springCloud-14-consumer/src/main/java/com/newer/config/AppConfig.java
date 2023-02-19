package com.newer.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration


public class AppConfig {
//    @Bean//调用http网络对象
//    @LoadBalanced//轮询
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    @Bean
    @LoadBalanced // 使用轮询(注：使用轮询过后可以使用服务名,但不能用id地址)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
