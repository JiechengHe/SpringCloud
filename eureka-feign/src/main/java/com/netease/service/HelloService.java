package com.netease.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("HelloService")
public interface HelloService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello();

}
