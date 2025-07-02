package com.api.demo.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${external.api.base-url}")
    private String baseURL;

    @Bean
    public WebClient webClient(){
            return WebClient.builder()
                    .baseUrl(baseURL)
                    .build();
    }
}
