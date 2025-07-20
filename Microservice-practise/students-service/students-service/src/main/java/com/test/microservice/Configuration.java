package com.test.microservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties("student-service")
@Component
public class Configuration {
    private int minMarks;
    private int maxMarks;

}
