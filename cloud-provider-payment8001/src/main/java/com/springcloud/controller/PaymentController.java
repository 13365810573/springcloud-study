package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/11/22 00229:29
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payments/")
    public CommonResult create(@RequestBody Payment p){

        int result = paymentService.create(p);

        if (result>0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort);
        }else {
            return new CommonResult(400,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/payments/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort"+serverPort,payment);
        }else {
            return new CommonResult(400,"查询失败");
        }
    }
    @GetMapping(value = "/payments/lb")
    public String getPaymentById(){
        return serverPort;
    }



    @GetMapping(value = "/payments/fegin/timeout")
    public String paymentFeginTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
