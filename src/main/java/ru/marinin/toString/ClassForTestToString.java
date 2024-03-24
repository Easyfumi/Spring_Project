package ru.marinin.toString;

import org.springframework.stereotype.Component;

@Component
@ToString
public class ClassForTestToString implements ToStringable{
    String city;
    int age;

    public ClassForTestToString() {
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
