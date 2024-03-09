package ru.marinin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    String hello() {
        return "Hello world!";
    }

    @Bean
    Date getStartDate() {
        return new Date();
    }

    @Bean
    Predicate<Integer> gradesRange() {
        return (x) -> x>=2 && x<=5;
    }

    @Bean
    int max() {
        return 20;
    }

    @Bean
    int min() {
        return -20;
    }




}
