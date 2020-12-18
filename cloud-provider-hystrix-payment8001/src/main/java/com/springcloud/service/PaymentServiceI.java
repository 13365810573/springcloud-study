package com.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/3 000314:55
 */
public interface PaymentServiceI {

    public String PaymentInfo_OK (@PathVariable("id") Integer id);

    public String PaymentInfo_TimeOut (@PathVariable("id") Integer id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);
}
