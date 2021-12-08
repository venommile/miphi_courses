package ru.miphi.dz6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirFind {

    public static void main(String[] args) {

        try (Stream<Path> files = Files.find(Paths.get("."), 2, (p, a) -> a.isDirectory())) { // Add try with resources

            System.out.println("\n=== Find all dirs ===");
            files.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
