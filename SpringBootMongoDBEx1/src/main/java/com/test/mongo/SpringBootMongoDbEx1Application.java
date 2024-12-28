package com.test.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.test.mongo.repository")
@ComponentScan("com.test.mongo.*")
public class SpringBootMongoDbEx1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDbEx1Application.class, args);
    }
}
