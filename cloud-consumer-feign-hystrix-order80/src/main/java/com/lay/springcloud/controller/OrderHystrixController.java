package com.lay.springcloud.controller;

import com.lay.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
//只针对当前类有效的fallback方法，如果想设置全局的fallback方法就要定义一个全局处理类来实现我们的feign接口并重写里面的方法，
//接着在我们的主启动类上定义我们的全局处理类！
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }

    //自定义的fallback方法。
    //@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
//    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int a= 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    //当我们的消费者和提供者都设置了断路器，如果提供者那边出现问题会优先调用消费者的回滚方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "消费者80，支付系统繁忙";
    }


    //全局fallback方法，不能有传参
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试！";
    }

}
