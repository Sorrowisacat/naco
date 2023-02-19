package com.newer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

@Service
@FeignClient(name = "nacosprovider")
public interface OrderService {

    @GetMapping("/update")
    String test();
}
