package com.test.currencyconversion;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    private final Environment env;

    public CurrencyConversionController(Environment env) {
        this.env = env;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
        CurrencyConversion currencyConversion = new CurrencyConversion(10001L, from, to, quantity, BigDecimal.ONE, BigDecimal.ONE);
        String port = env.getProperty("local.server.port");
        currencyConversion.setEnvironment(port);
        return currencyConversion;
    }
}
