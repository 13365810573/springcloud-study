package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/11 001116:14
 */
@SpringBootApplication
@EnableZuulProxy

public class TestZuulMain10010 {

    public static void main(String[] args) {
        SpringApplication.run(TestZuulMain10010.class,args);
    }
}
