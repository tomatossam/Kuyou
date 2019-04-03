package com.example.kuyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.kuyou.*"})
@MapperScan("com.example.kuyou.dao")
public class KuyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuyouApplication.class, args);
    }

}
