package com.test.currencyconversion;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    private final RestTemplate template;
private final CurrencyExchangeProxy proxy;

    public CurrencyConversionController(CurrencyExchangeProxy proxy,RestTemplate template) {
        this.proxy = proxy;
        this.template = template;
    }

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {
        Map<String, String> urivariables = new HashMap<>();
        urivariables.put("from", from);
        urivariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = template.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, urivariables);
        CurrencyConversion conversion = responseEntity.getBody();
        return new CurrencyConversion(10001L, from, to, quantity, conversion.getConversionMultiple(), quantity.multiply(conversion.getConversionMultiple()), conversion.getEnvironment()+" RestTemplate");
    }
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from,
                                                          @PathVariable String to,
                                                          @PathVariable BigDecimal quantity) {

        CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
        return new CurrencyConversion(10001L, from, to, quantity, conversion.getConversionMultiple(), quantity.multiply(conversion.getConversionMultiple()), conversion.getEnvironment()+" Feign");
    }
}
