package com.atguigu.gmall.gateway;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther ZYG
 * @Date 2022/8/22
 */
@SpringCloudApplication
//@EnableCircuitBreaker//开启服务熔断降级、流量保护
//@EnableDiscoveryClient//开启服务发现
//@SpringBootApplication
public class GatewayMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMainApplication.class,args);
    }
}
