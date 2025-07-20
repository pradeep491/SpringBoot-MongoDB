package com.test.microservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    private final Configuration configuration;

    public StudentRestController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/marks")
    public Marks getMarks() {
        //return new Marks(35, 100);
        return new Marks(configuration.getMinMarks(), configuration.getMaxMarks());
    }
}
