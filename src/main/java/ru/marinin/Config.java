package ru.marinin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.function.Predicate;

@Configuration
public class Config {
    @Bean
    String hello() {
        return "Hello world!";
    }

    @Bean @Lazy
    Date getStartDate() {
        return new Date();
    }

    @Bean
    Predicate<Integer> gradesRange() {
        return (x) -> x>=2 && x<=5;
    }

    @Bean
    int max() {
        return 10;
    }

    @Bean
    int min() {
        return -10;
    }


    @Bean
    @Scope("prototype")
    Reviews getRewiew(List<Reviews> list) {
        list.sort((o1, o2) -> o2.text.grade-o1.text.grade);
        return list.get(0);
    }




}
