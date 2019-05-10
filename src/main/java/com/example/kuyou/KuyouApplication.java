package com.example.kuyou;

import com.example.kuyou.dao.DataConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication(scanBasePackages={"com.example.kuyou.*"})
@MapperScan("com.example.kuyou.dao")
public class KuyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuyouApplication.class, args);
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);
    }




}
