package ru.marinin.Trafficlight;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Trafficlight{
    Color color=Colors.YELLOW2;
    @Bean
    @Scope("prototype")
    public String next(){
        color=color.next();
        return color.toString();
    }
}
interface Color{
    Colors next();
}

