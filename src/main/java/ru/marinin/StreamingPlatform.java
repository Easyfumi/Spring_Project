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

@Component
public class StreamingPlatform {
    @Autowired Input input;
    @Autowired ChangeLines changeLines;
    @Autowired Output output;
//    @Bean
//    boolean start(Input input, ChangeLines changeLines, Output output) {
//        String  string = input.read();
//        List<String> list = changeLines.change(string);
//        return output.write(list);
//    }
}
