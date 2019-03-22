package com.netease.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hejiecheng
 */
@RestController
public class InfoController {

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello! Now Port is "+port +" And hostname is " +name;
    }

}
