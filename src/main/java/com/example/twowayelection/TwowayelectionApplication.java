package com.example.twowayelection;

import com.example.twowayelection.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TwowayelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwowayelectionApplication.class, args);
    }

}
