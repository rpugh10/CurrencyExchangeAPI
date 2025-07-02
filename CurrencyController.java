package com.api.demo.controller;

import com.api.demo.service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService)
    {
        this.currencyService = currencyService;
    }

    @GetMapping("/rates")
    public String getRates(@RequestParam(defaultValue = "CAD") String base){
        return currencyService.getExchangeRate(base);
    }
}
