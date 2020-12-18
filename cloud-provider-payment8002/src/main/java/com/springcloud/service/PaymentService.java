package com.springcloud.service;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/11/22 00229:24
 */
public interface PaymentService {

    public  int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
