package com.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ceshi
 * @Title:
 * @Package
 * @Description:
 * @date 2020/12/8 00089:57
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route",r -> r.path("/bilibili").uri("https://www.bilibili.com/")).build();
        return routes.build();
    }
}
