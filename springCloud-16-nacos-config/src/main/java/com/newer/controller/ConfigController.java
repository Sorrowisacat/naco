package com.newer.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String name;



    @RequestMapping("/config/info")
    public String info() {
        return "config:" + port;
    }

}
