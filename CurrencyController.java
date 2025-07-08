package com.example.getAPI.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.getAPI.service.CurrencyService;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }

    @GetMapping(path = "/rates")
    public String getRates(@RequestParam(defaultValue = "CAD")String base)
    {
        return currencyService.getExchangeRates(base);
    }
}
