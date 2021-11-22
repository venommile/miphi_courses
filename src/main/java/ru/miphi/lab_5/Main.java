package ru.miphi.lab_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private ArrayList emptyfield = null;

    public static void main(String[] args) {
        try {
            generateArrayIndexOutOfBoundsException(5);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Вылезли за переделы Массива,ну ничего страшного тяу-тяу,Выведем в stderr и потом разберёмся");
            System.err.println(Arrays.toString(ex.getStackTrace()));
            System.out.println("-------------------");
        }

        try {
            generateFileNotFoundException();
        } catch (Exception fileEx) {
            System.out.println("файл не найден(((");
            System.err.println("Bad way to file");
            System.out.println("-------------------");

        }

        try {
            ArrayList emptyfield = new Main().getEmptyfield();
            emptyfield.forEach(System.out::println);
        } catch (NullPointerException nullPtr) {
            System.out.println("Null Array");
            System.out.println("-------------------");
        }

        try {
            generateIOException();
        } catch (IOException e) {
            System.out.println("Input stream error");
            System.out.println("-------------------");
        }

        try {
            generateClassCastException();
        } catch (ClassCastException castException) {
            System.out.println("Cast Error");
            System.out.println("-------------------");
        }
        try {
            generateArithmeticException();
        } catch (ArithmeticException exception) {
            System.out.println("ArithmeticException");
            System.out.println("-------------------");
        }

        try {
            generateOutOfMemoryError();
        }
        catch (OutOfMemoryError memoryError){
            System.out.println("Memory Error!!");
            System.out.println("-------------------");

        }
        try{
            generateStackOverflowError();
        }
        catch (StackOverflowError stackOverflowError){
            System.out.println("Stack over flow!!");
            System.out.println("-------------------");

        }
    }

    public static void generateArrayIndexOutOfBoundsException(int index) {
        int[] array = new int[index];
        Integer k = array[index];
    }

    public static void generateFileNotFoundException() throws FileNotFoundException {
        BufferedReader rd = new BufferedReader(new FileReader(new File("not found")));
    }

    public ArrayList getEmptyfield() {
        return emptyfield;
    }

    public static void generateIOException() throws IOException {
        File newFile = new File("test.txt");
        FileInputStream stream = new FileInputStream(newFile);

    }

    public static void generateClassCastException() {
        var arr = new ArrayList<>();
        arr.add("one");
        arr.add("two");
        arr.add(3);
        arr.stream().map(arg -> (Integer) arg).forEach(System.out::println);
    }

    public static void generateArithmeticException() {
        Integer k = (6 + 6) / (6 - 6);
    }


    public static void generateOutOfMemoryError() {
        var arr = new ArrayList<Integer>();
        while (true) {
            arr.add(1);
        }
    }

    public static void generateStackOverflowError() {
        generateStackOverflowError();
    }

}
