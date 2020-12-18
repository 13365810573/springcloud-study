package com.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/3 000316:05
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String PaymentInfo_TimeOut (@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK (@PathVariable("id") Integer id);
}
