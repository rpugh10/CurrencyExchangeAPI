package com.api.demo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {

    private final WebClient webClient;

    @Value("${external.api.key}")
    private String apiKey;

    public CurrencyService(WebClient webClient)
    {
        this.webClient = webClient;
    }

    public String getExchangeRate(String baseCurrency) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("latest")
                        .queryParam("apikey", apiKey)
                        .queryParam("base_currency", baseCurrency)
                        .build())

                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
