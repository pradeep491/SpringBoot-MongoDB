package com.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalConfigController {

    @Autowired
     Environment env;

    @GetMapping("/getConfig")
    public String getConfig() {
        return env.getProperty("spring.application.name");
    }
}
