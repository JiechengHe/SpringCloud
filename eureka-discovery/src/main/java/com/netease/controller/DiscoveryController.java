package com.netease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author hejiecheng
 */
@RestController
public class DiscoveryController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public DiscoveryController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @RequestMapping(value = "/instance", method = RequestMethod.GET)
    public String getInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances("HELLOSERVICE");
        StringBuilder stringBuilder = new StringBuilder();
        for(ServiceInstance serviceInstance : list) {
            stringBuilder.append(serviceInstance.getUri() + "\n");
        }
        return stringBuilder.toString();
    }

}
