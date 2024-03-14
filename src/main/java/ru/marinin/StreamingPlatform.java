package ru.marinin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.marinin.StreamingPlatformService.ChangeLines;
import ru.marinin.StreamingPlatformService.Input;
import ru.marinin.StreamingPlatformService.Output;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Component
public class StreamingPlatform {
    @Autowired
    public Supplier<String> input;
    @Autowired
    public UnaryOperator<String> changeLines;
    @Autowired
    public Consumer<String> output;

    public void start() {
        String text = input.get();
        text = changeLines.apply(text);
        output.accept(text);
    }

}
