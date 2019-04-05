package com.netease.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hejiecheng
 * @Date 2019-04-05
 */

// ribbon负载均衡策略
@Configuration
public class RibbonConfig {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
