package ru.marinin.StreamingPlatformService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
@Configuration
public class Output {
    @Bean
    @Lazy
    public boolean write(List<String> readyToWrite) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, куда хотите записать данные:");
        String path = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(path, false);
            String text = readyToWrite.toString();
            writer.write(text);
            writer.flush();
            return true;
        } catch (IOException e) {
            throw new RuntimeException("write goes wrong");
        }
    }
}
