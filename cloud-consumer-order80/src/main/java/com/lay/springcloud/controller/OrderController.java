package com.lay.springcloud.controller;


import com.lay.springcloud.entity.CommonResult;
import com.lay.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Dragon code!
 * @create 2022-07-12 13:48
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/payment/create", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        log.info("*****************插入数据:" + payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        log.info("********查询的id：" + id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") Long id){
        log.info("********查询的id：" + id);
        //getForObject两个参数：请求地址，返回的对象类型
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

        //getStatusCode获取状态码，is2xxSuccessful如果是状态码是2xx
        if(entity.getStatusCode().is2xxSuccessful()){
            //返回body
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/createEntity")
    public CommonResult<Payment> create2(Payment payment){
        log.info("********插入的数据：" + payment);
        //postForObject分别有三个参数：请求地址，请求参数，返回的对象类型
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        //这个地方由于使用了负载均衡不能直接写url进行调用，而是应该写服务名。如果非要使用URl需要在配置类里面分别配置负载均衡与默认优先选择，即写两个RestTemplate方法
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin", String.class);
        return result;
    }

}
