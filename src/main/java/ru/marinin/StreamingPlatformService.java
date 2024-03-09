package ru.marinin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


@Configuration
public class StreamingPlatformService {
    String input;
    List<String> readyToWrite = new ArrayList<>();
    @Bean
    @Lazy
    StreamingPlatformService input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, откуда хотите считать данные:");

        try {
            String path = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            input = reader.readLine();
            reader.close();
            return this;
        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }
    }

    @Bean
    @Lazy
    StreamingPlatformService changeLines() {
        readyToWrite = Arrays.stream(input.split(" "))
                .map(x -> x.toUpperCase())
                .map(x -> x.replaceAll("A", ""))
                .filter(x -> x.length()>4)
                .collect(Collectors.toList());
        return this;
    }

    @Bean
    @Lazy
    String writeToFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, куда хотите записать данные:");
        String path = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(path, false);
            String text = readyToWrite.toString();
            writer.write(text);
            writer.flush();
            return "Данные записаны в файл " + path;
        } catch (IOException e) {
            return "Данные не записаны";
        }
    }





}
