package com.tech.jpa.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Created by x074823 on 8/15/2016.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}
