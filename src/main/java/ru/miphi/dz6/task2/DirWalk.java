package ru.miphi.dz6.task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirWalk {
  public static void main(String[] args) {  

    try(Stream<Path> files = Files.walk(Paths.get("."))){// Add try with resources here

        System.out.println("\n=== Dir walk ===");
        files.forEach(System.out::println);

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

    try(Stream<Path> files = Files.walk(Paths.get("."))){

        System.out.println("\n=== Dir build ===");
        files
            .filter(path -> path.toString().contains("build"))
            .forEach(line -> System.out.println(line));  

    }catch (IOException e){
        System.out.println("Error: " + e.getMessage());
    }

  } 
}
