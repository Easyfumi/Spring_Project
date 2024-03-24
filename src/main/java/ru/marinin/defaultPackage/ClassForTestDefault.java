package ru.marinin.defaultPackage;

import org.springframework.stereotype.Component;
import ru.marinin.random.Random;
@Component
@DefaultAnnotation
public class ClassForTestDefault {
    private String string;
    public int x;
    public Random random;

    public ClassForTestDefault() {
    }

    @Override
    public String toString() {
        return "ClassForTestDefault{" +
                "str='" + string + '\'' +
                ", x=" + x +
                ", random=" + random +
                '}';
    }
}
