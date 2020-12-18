package com.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentServiceI;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/3 000314:56
 */
@Service
public class PaymentService implements PaymentServiceI {

    public String PaymentInfo_OK (Integer id){

        return "线程池： "+ Thread.currentThread().getName()+"   PaymentInfo_OK  , id : "+ id;

    }
    //**服务降级
    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String PaymentInfo_TimeOut (@PathVariable("id") Integer id){

        try {

            TimeUnit.MILLISECONDS.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return "线程池： "+ Thread.currentThread().getName()+"   PaymentInfo_TimeOut  , id : "+ id +"耗时"+"秒";
    }

    public String PaymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "线程池： "+ Thread.currentThread().getName()+"  8001系统繁忙或者运行出错  , id : "+ id +"超时了┭┮﹏┭┮" ;
    }
    
    //**服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallBack",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0)
        {
            throw new RuntimeException("*********id 不能为负数");

        }
        String  serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+ serialNumber;

    }

    public String paymentCircuitBreaker_fallBack(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，┭┮﹏┭┮！！！ id"+id;
    }
}
