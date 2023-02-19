package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloud14ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloud14ProviderApplication.class, args);
    }

}
