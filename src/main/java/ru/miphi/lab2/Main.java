package ru.miphi.lab2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input_string;
        input_string = sc.nextLine();
        String str = "";
        task1(input_string);
        task2(input_string);


    }

    public static void task1(String input_string) {

        HashMap<String, Integer> map = new LinkedHashMap();
        String str = "";
        for (int i = 0; i < input_string.length(); i++) {
            if (input_string.charAt(i) == ' ') {
                if (str != "") {
                    if (map.containsKey(str)) {
                        int k = map.get(str);
                        map.put(str, k + 1);
                    } else {
                        map.put(str, 1);
                    }
                }
                str = "";
            } else if (i == input_string.length()-1) {
                str += input_string.charAt(i);
                if (map.containsKey(str)) {
                    int k = map.get(str);
                    map.put(str, k + 1);
                } else {
                    map.put(str, 1);
                }


            } else {
                str += input_string.charAt(i);
            }
        }
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

    }

    public static void task2(String input_string) {
        HashSet<String> set = new LinkedHashSet<>();
        String str = "";
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < input_string.length(); i++) {
            if (input_string.charAt(i) == ' ') {
                if (str != "") {
                    if (!set.contains(str)) {
                        set.add(str);
                        list.add(str);
                    }

                }
                str = "";
            } else {
                str += input_string.charAt(i);
            }
        }
        for (String key : list) {
            System.out.print(key + " ");
        }


    }
}
