package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("one", "two");
        List<String> list2 = Arrays.asList("three", "four");
        List<String> list3 = Arrays.asList("five", "six");

        List<List<String>> list4 = new ArrayList<>();
        list4.add(list1);
        list4.add(list2);
        list4.add(list3);

        List<String> finalList = list4.stream().flatMap(List::stream).toList();
        finalList.forEach(System.out::println);
        System.out.println(finalList);
    }
}