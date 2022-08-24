package com.lay.springcloud;

import com.lay.ribbon.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class OrderConsumerMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerMain80.class, args);
    }
}
