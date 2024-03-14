package ru.marinin.StreamingPlatformService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Supplier;

@Component
public class Input implements Supplier<String> {

    @Override
    public String get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, откуда хотите считать данные:");
        try {
            String path = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String result = reader.readLine();
            reader.close();
            return result;
        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }
    }
}
