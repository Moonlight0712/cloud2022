package com.lay.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Dragon code!
 * @create 2022-05-03 17:25
 * 解释：
 * @EnableEurekaClient
 * @EnableDiscoveryClient
 * 两个注解都可以将我们的微服务注册到我们的主持中心，区别是EnableDiscoveryClient注解可以将服务注册到其他类型的注册中心中
 * 而我们的EnableEurekaClient注解只适用于Eureka作为注册中心
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
