package com.newer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/name/{name}")
    public String getName(@PathVariable String name) {
        return "name"+ name;
    }

    @GetMapping("/getmsg")
    public String getGetMsg(){
        String Url = "http://127.0.0.1:8082/hello";
        return restTemplate.getForObject(Url,String.class);
    }

}
