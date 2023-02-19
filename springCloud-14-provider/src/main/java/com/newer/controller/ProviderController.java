package com.newer.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/update")
    private String update(){
        return "update成功"+port;
    }
}
