package ru.miphi.dz6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
    public static void main(String[] args) {


        try (Stream<Path> lines = Files.list(Paths.get("."))) { // Add Try with resources here   ---------
            System.out.println("\n=== Dir list ===");
//             Print directory list here
            lines.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
