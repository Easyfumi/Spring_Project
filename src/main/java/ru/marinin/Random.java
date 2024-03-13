package ru.marinin;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class Random {
    private List<Integer> list = new ArrayList<>();
    private int max = 0;
    private int min = 0;
    private int num;
    void initList(int min, int max) {
        list = new ArrayList<>();
        this.max = max;
        this.min = min;
        for (int i=min; i<max+1; i++) {
            list.add(i);
        }
    }

    void checkChange(int min, int max) {
        if (!(max == this.max && min == this.min)) {
            initList(min, max);
        }
    }

    void initNum() {
        if (list.size()==0) throw new RuntimeException("free nums ended");
        changeNum();
        if (list.contains(num)) {
            Object o = num;
            list.remove(o);
        } else {
            initNum();
        }
    }
    void changeNum() {
        num = ThreadLocalRandom.current().nextInt(min,max+1);
    }

    @Scope("prototype")
    @Bean
    int randomInt(@Qualifier("min") int min, @Qualifier("max") int max) {
        checkChange(min, max);
        initNum();
        return num;
    }
}
