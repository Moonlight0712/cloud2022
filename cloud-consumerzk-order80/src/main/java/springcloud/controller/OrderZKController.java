package springcloud.controller;


import com.lay.springcloud.entity.CommonResult;
import com.lay.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Dragon code!
 * @create 2022-07-12 13:48
 */
@RestController
@Slf4j
public class OrderZKController {
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
}
