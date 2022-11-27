package com.example.mongodbcurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.mongodbcurd.repository")
@ComponentScan(basePackages = "com.example.mongodbcurd.*")
public class MongoDbStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoDbStarterApplication.class, args);
    }

}
