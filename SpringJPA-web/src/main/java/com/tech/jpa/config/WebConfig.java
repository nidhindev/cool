package com.tech.jpa.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by x074823 on 8/15/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.tech.jpa")
public class WebConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
