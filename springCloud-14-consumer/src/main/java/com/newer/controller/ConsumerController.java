package com.newer.controller;

import com.newer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Random;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/getConsumer")
    private String update(){
        String path ="http://localhost:8012/update";
//        System.out.println(appName+"====");
//        String path ="http://nacos-provider/update";
        return restTemplate.getForObject(path,String.class);
    }

    @Autowired
    OrderService orderService;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    // openfeign方法调用
    @GetMapping("/msg")
    public String order() {
        return  orderService.test();
    }

    // 代码式
    @GetMapping("/Test1")
    public String orderAdd() {
        //String url = "nacosprovider";
        ServiceInstance service = loadBalancerClient.choose("nacosprovider");
        String url = service.getHost()+":"+service.getPort();
        String path = "http://" + url + "/update";
        return restTemplate.getForObject(path, String.class);
    }
    //用服务名调用(注:要开启轮询注解);
    @GetMapping("/Test2")
    public String orderAdds(){
        String url = "";
        String path = "http://nacosprovider/update";
        return restTemplate.getForObject(path, String.class);
    }

    //随机调用
    @GetMapping("/Test3")
    public String orderAddss(){
        List<ServiceInstance> instances = this.discoveryClient.getInstances("nacosprovider");
        int index = new Random().nextInt(instances.size());
        ServiceInstance service = instances.get(index);
        String url = service.getHost()+":"+service.getPort();
        String path = "http://" + url + "/update";
        System.out.println("path:==" + path);
        return restTemplate.getForObject(path,String.class);
    }

//    @GetMapping("Test4")
//    public String orderTest4(){
//
//        return restTemplate.getForObject(new String(),String.class);
//     }
}
