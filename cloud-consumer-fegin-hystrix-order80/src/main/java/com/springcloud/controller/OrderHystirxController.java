package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/3 000316:24
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand
    public String PaymentInfo_OK (@PathVariable("id") Integer id){
        int age = 10/0;
        String result = service.PaymentInfo_OK(id);

        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "PaymentInfoOutFallBackTimeOut",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    public String PaymentInfo_Timeout (@PathVariable("id") Integer id){

        String result = service.PaymentInfo_TimeOut(id);

        return result;
    }

    public String PaymentInfoOutFallBackTimeOut (@PathVariable("id") Integer id){
        return "超时了┭┮﹏┭┮呜呜呜呜呜呜呜呜" ;
    }



    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试Thanks♪(･ω･)ﾉ";
    }


}
