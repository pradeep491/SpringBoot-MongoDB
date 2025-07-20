package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesInArray {
	public static void main(String[] args) {
		Integer a[] = new Integer[] { 10, 20, 30, 10, 30, 50, 60, 40, 30 };
		Set<Integer> set = new LinkedHashSet<>(Arrays.asList(a));
		for (Integer i : set) {
			System.out.println(i);
		}
		System.out.println("=======================");
		List<Integer> list = Arrays.asList(a);
		list.stream().sorted(Comparator.naturalOrder()).distinct().toList().forEach(System.out::println);
		System.out.println("=================");
		list.stream().sorted(Comparator.reverseOrder()).distinct().toList().forEach(System.out::println);
	}
}
