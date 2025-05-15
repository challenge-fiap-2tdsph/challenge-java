package com.grupo.challenge_java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ChallengeJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeJavaApplication.class, args);
    }

}