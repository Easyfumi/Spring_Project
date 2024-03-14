package ru.marinin.StreamingPlatformService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

@Component
public class Output implements Consumer<String> {

    @Override
    public void accept(String readyToWrite) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла, куда хотите записать данные:");
        String path = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter(path, false);
            writer.write(readyToWrite);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("write goes wrong");
        }
    }
}
