package com.springcloud;

import com.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/11/22 002211:38
 */
@SpringBootApplication
@EnableEurekaClient
/*@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)*/
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
