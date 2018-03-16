package com.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.boot.autoconfigure.SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class SpringBootApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
           SpringApplication.run(SpringBootApplication.class, args);
    }
}