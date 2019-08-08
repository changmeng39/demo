package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

//@MapperScan("com.dao")
@ComponentScan("com.controller")
@ComponentScan("com.service")
@ComponentScan("com.service.impl")
@ComponentScan("com.timedtask")
@EnableScheduling
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    //我是master

    public static void main(String[] args) {
        System.out.println("启动开始``````````````````````````");
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("启动成功``````````````````````````");
    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }
}
