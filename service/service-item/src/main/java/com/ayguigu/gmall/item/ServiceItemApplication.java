package com.ayguigu.gmall.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auther ZYG
 * @Date 2022/9/9
 */
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源自动配置
//@ComponentScan({"com.atguigu.gmall"})
//@EnableDiscoveryClient
//@EnableFeignClients(basePackages= {"com.atguigu.gmall"})
@EnableFeignClients

@SpringCloudApplication
public class ServiceItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceItemApplication.class,args);
    }
}
