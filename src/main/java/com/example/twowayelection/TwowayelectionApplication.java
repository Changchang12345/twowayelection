package com.example.twowayelection;

import com.example.twowayelection.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;
import java.net.PasswordAuthentication;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class TwowayelectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwowayelectionApplication.class, args);
    }

    @Bean
    public PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }
}
