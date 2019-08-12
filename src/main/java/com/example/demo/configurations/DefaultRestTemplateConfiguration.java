package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DefaultRestTemplateConfiguration {

    @Bean
    public RestTemplate defaultRestTemplate() {
        return new RestTemplate(new SimpleClientHttpRequestFactory());
    }
}
