package ru.miphi.dz6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class P04NioReadAll {
    public static void main(String[] args) {

        Path file = Paths.get("src/main/java/ru/miphi/dz6/task1/hamlet.txt");
        List<String> fileArr;
        try {
            // Read file into array here
            fileArr = Files.readAllLines(file);

            System.out.println("\n=== Lord Count ===");//to lower case?
            long wordCount = fileArr.stream().filter(line -> line.toLowerCase(Locale.ROOT).contains("lord")).count(); // Replace with your pipeline

            System.out.println("Word count: " + wordCount);

            System.out.println("\n=== Prison Count ===");
            wordCount = 0; // Replace with your pipeline
            wordCount = fileArr.stream().filter(line -> line.toLowerCase(Locale.ROOT).contains("prison")).count(); // Replace with your pipeline

            System.out.println("Word count: " + wordCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
