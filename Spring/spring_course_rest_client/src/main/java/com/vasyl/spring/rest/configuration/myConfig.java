package com.vasyl.spring.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.vasyl.spring.rest")
public class myConfig {

    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

}
