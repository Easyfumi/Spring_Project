package ru.marinin.StreamingPlatformService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
@Component
public class ChangeLines implements UnaryOperator<String> {

    @Override
    public String apply(String input) {
        return Arrays.stream(input.split(" "))
                .map(x -> x.toUpperCase())
                .map(x -> x.replaceAll("A", ""))
                .filter(x -> x.length()>4)
                .collect(Collectors.toList()).toString();
    }

}
