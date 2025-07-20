package com.test.currencyexchange;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private final Environment env;

    public CurrencyExchangeController(Environment env) {
        this.env = env;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyexchange = new CurrencyExchange(10001L, from, to, BigDecimal.valueOf(82));
        String port = env.getProperty("local.server.port");
        currencyexchange.setEnvironment(port);
        return currencyexchange;
    }
}
