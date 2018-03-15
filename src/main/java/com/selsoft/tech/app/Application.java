package com.selsoft.tech.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.selsoft.tech.controller")
@ComponentScan("com.selsoft.tech.query")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
