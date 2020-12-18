package com.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/3 000310:55
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feiginLoggerLevel(){
        return Logger.Level.FULL;
    }
}
