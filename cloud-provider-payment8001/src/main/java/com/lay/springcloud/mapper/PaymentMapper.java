package com.lay.springcloud.mapper;

import com.lay.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Dragon code!
 * @create 2022-05-03 17:36
 */

//为了省略给每一个mapper都写上Mapper注解，我们可以直接在启动类上指明mapper接口扫描的包
@Mapper
public interface PaymentMapper {
    //增
    int create(Payment payment);

    //改
    //@Param()的作用就是给形参起别名
    Payment getPaymentById(@Param("id") Long id);
}
