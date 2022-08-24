package com.lay.springcloud.service;

import com.lay.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dragon code!
 * @create 2022-05-03 19:50
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
