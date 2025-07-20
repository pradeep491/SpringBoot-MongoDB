package com.test;

import java.util.Arrays;
import java.util.List;

public class Example {
public static void main(String[] args) {
	List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
	List<String> uniqueStrings = listOfStrings.stream().distinct().toList();
	uniqueStrings.forEach(System.out::println);
}
}
