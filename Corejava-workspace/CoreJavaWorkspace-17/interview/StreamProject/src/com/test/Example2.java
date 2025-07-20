package com.test;

import java.util.Arrays;
import java.util.List;

public class Example2 {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> list1 = list.stream().distinct().toList();
		list1.forEach(System.out::println);
		System.out.println("==========================");
		list1.stream().reduce(1, (a, b) -> a * b);
		
		
	}
}
