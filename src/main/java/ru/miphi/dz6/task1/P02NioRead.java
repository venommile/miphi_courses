package ru.miphi.dz6.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class P02NioRead {

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/ru/miphi/dz6/task1/hamlet.txt"))){ // Create Try with Resources here

            System.out.println("\n=== Entire File ===");
            lines.forEach(System.out::println);
            // print lines here

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
