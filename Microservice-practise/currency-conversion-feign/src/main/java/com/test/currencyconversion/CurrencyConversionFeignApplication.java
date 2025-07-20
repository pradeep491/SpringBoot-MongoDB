package com.test.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionFeignApplication.class, args);
	}
@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
}
}
