package ru.marinin.defaultPackage;

import org.springframework.stereotype.Component;
import ru.marinin.random.Random;

@Component
public class DefaultConfig {
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
