package com.example.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogApplication {

    public static void main(String[] args) {
        System.out.println("Hello world");
        SpringApplication.run(LogApplication.class, args);
    }

}
