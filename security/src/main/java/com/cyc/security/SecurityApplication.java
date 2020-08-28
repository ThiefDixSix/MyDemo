package com.cyc.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cyc.security.dao")
public class SecurityApplication {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("-------------------------程序开始启动-------------------------");
        SpringApplication.run(SecurityApplication.class, args);
        System.out.println("-------------------------程序启动成功，耗时："+(System.currentTimeMillis()-startTime)/1000+"s-------------------------");

    }

}
