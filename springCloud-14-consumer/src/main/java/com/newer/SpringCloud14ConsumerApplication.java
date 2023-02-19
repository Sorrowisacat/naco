package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients // 启用openFeign进行服务调用
@SpringBootApplication
public class SpringCloud14ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud14ConsumerApplication.class, args);
    }

}
