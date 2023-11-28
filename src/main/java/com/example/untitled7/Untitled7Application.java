package com.example.untitled7;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.example.untitled7.dao")
public class Untitled7Application {

    public static void main(String[] args) {
        SpringApplication.run(Untitled7Application.class, args);
    }

}
