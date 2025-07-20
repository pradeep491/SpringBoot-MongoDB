package com.test.currency_exchange_jpa;

import com.test.currency_exchange_jpa.bean.CurrencyExchange;
import com.test.currency_exchange_jpa.repos.CurrencyExchangeRepository;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private final Environment env;
    private final CurrencyExchangeRepository repository;

    public CurrencyExchangeController(Environment env, CurrencyExchangeRepository repository) {
        this.env = env;
        this.repository = repository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        //CurrencyExchange currencyexchange = new CurrencyExchange(10001L, from, to, BigDecimal.valueOf(82));
        CurrencyExchange currencyexchange = repository.findByFromAndTo(from, to);
        String port = env.getProperty("local.server.port");
        currencyexchange.setEnvironment(port);
        return currencyexchange;
    }
}
