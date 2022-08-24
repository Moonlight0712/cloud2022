package com.lay.springcloud.service.impl;

import com.lay.springcloud.entity.Payment;
import com.lay.springcloud.mapper.PaymentMapper;
import com.lay.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Dragon code!
 * @create 2022-05-03 19:51
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    //注入方式是byName
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
