package com.netease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author hejiecheng
 * @Date 2019-04-05
 */

@RestController
public class RibbonController {

    private RestTemplate restTemplate;

    @Autowired
    public RibbonController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/ribbonSayHello")
    public String ribbonSayHello() {
        return restTemplate.getForObject("http://HELLOSERVICE/hello", String.class);
    }

}
