package ru.marinin.Trafficlight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Trafficlight{
    @Autowired @Qualifier("starter")
    Color startedColor;
    @Bean
    @Scope("prototype")
    public Color next(){
        Color current = startedColor;
        startedColor = startedColor.next();
        return current;
    }
}

