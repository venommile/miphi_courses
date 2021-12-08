package ru.miphi.lab6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

public class Task1 {
    public static void main(String[] args) {
        String fileName = "";
        String inputString = "";
        try {
            fileName = args[0];
            inputString = args[1];

        } catch (IndexOutOfBoundsException exception) {
            System.err.println("Invalid input");
        }
        // Function<String, Long> checkLine = x -> {
        //   return Arrays.stream(x.split(" ")).filter(y -> y.equals(inputString)).count();
        //};  почему без копирования в finalInputString оно не будет работать?
        String finalInputString = inputString;
        Function<String, Long> checkLine = x -> {
            return Arrays.stream(x.split(" ")).filter(y -> y.equals(finalInputString)).count();
        };
        try (FileReader in = new FileReader(fileName);
             BufferedReader reader = new BufferedReader(in)) {
            long ans = reader.lines().mapToLong(checkLine::apply).sum();
            System.out.println(ans);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
