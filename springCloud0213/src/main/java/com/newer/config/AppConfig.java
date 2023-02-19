package com.newer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean//调用http网络对象
    @LoadBalanced // 轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
