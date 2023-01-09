package com.wusan.gulimall.member;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 *
 * 这样我们准备好了优惠券的调用内容
 * 在member的配置类上加注解@EnableFeignClients(basePackages="com.yxj.gulimall.member.feign")，
 * 告诉spring这里面是一个远程调用客户端，member要调用的接口
 *
 * @author wusan
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wusan.gulimall.member.feign")
@MapperScan("com.wusan.gulimall.member.dao")
@SpringBootApplication
public class GulimallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallMemberApplication.class, args);
    }

}
