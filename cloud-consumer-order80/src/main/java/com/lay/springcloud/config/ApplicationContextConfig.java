package com.lay.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dragon code!
 * @create 2022-07-12 0:44
 */
@Configuration
public class ApplicationContextConfig {
    //基于原始的RestTemplate来实现远程http访问方法
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate1(){
        return new RestTemplate();
    }

//    @Primary
//    @Bean
//    public RestTemplate restTemplate2() {
//        return new RestTemplate();
//    }

    }
