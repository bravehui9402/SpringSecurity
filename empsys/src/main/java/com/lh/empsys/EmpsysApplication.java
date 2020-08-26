package com.lh.empsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lh.empsys.sys.mapper")
@MapperScan("com.lh.empsys.common.mapper")
public class EmpsysApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpsysApplication.class, args);
    }

}
