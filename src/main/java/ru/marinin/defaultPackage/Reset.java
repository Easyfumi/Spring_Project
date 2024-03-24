package ru.marinin.defaultPackage;

import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import ru.marinin.random.Random;

import java.lang.annotation.Target;

@Component
public class Reset {
    int getDefaultInt() {
        return 999;
    }
    String getDefaultString() {
        return "WOW";
    }
    Random getDefaultRandom() {
        return new Random();
    }
}
