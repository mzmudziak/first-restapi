package com.mzmudziak.firstrestapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class People {
    public static void main(String[] args) {

        System.out.println("Hello world");
        SpringApplication.run(People.class, args);
    }
}
