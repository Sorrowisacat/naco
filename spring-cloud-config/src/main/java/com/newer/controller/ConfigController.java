package com.newer.controller;

import com.newer.SpringCloudConfigApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RefreshScope  // 动态刷新配置
public class ConfigController {
//
    @Autowired
    SpringCloudConfigApplication springCloudConfigApplication;
    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String name;

    @RequestMapping("/config/info")
    public String info() {
        return ("config:" + port);
    }

}
