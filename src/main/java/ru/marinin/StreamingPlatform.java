package ru.marinin;

import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Configuration
public class StreamingPlatform {
    @Bean
    @Lazy
    String start() {
        List<String> resList = new ArrayList<>();
        ApplicationContext ctx = new AnnotationConfigApplicationContext(StreamingPlatformService.class);
        ctx.getBean("input");
        ctx.getBean("changeLines");
        return (String) ctx.getBean("writeToFile");



    }
}
