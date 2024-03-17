package ru.marinin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
@Component
public class StudentBuilder {
    @Autowired
    Predicate<Integer> gradesRange;
    public Student createStudent(String name, Integer... grades) {
        return new Student(name, gradesRange, grades);
    }
}
