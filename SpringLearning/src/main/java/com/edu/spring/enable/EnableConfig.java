package com.edu.spring.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = "com.edu.spring.bean")
public class EnableConfig {

    @Bean
    public String getHelloEnable() {
        return "hello enable demo";
    }

}
