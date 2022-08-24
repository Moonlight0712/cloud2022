package com.lay.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author Dragon code!
 * @create 2022-07-14 14:25
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_OK----";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----PaymentFallbackService\t fallback-paymentInfo_TimeOut----";
    }

}
