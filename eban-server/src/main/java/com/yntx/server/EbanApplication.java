package com.yntx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yntx.server.mapper")
public class EbanApplication {
    public static void main(String[] args) {
        SpringApplication.run(EbanApplication.class,args);
    }
}
