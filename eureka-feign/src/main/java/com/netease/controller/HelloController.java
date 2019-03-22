package com.netease.controller;

import com.netease.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hejiecheng
 */

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/sayHelloFeign")
    public String sayHello() throws Exception {
        return helloService.hello();
    }

}
