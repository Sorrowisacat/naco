package com.newer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloud16NacosConfigApplication {

    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringApplication.class, args);
          ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringCloud16NacosConfigApplication.class, args);
//        SpringApplication.run(SpringCloud16NacosConfigApplication.class, args);

        String port = applicationContext.getEnvironment().getProperty("port");
        System.err.println("port:" +port);
    }

}
