package com.springcloud.controller;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/2 000215:17
 */

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderFeginController {

    @Resource
    private PaymentFeignService service;

    /**
     * 通过fegin service 获取到端口数据 加载接口类到controller层得到对应 id的数据
     * @Author 卢杰龙
     * @param id
     * @return
     */
    @GetMapping(value = "/consumer/payments/{id}")
    public CommonResult<Payment> getPaymentGetById(@PathVariable("id") Long id){
        return service.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/fegin/timeout")
    public String paymentFeginTimeOut(){

        return service.paymentFeginTimeOut();
    }
}
