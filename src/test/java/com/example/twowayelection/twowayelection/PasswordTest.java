package com.example.twowayelection.twowayelection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;
import java.util.Base64;
import java.util.Random;

@Slf4j
@SpringBootTest

public class PasswordTest {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void test_password(){
        String pwd="12345";
        //Random r =new Random();
        //byte[] rb = new byte[16];
        //r.nextBytes(rb);
        //String result = Base64.getEncoder().encodeToString(rb);
        String result = passwordEncoder.encode(pwd);
        log.debug(result);
        log.debug(passwordEncoder.encode(pwd));
        log.debug("{}",passwordEncoder.matches("12345",result));
        log.debug("{}",passwordEncoder.matches("12345",passwordEncoder.encode(pwd)));
    }
}
