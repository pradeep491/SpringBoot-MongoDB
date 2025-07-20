package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumberEx {
	public static void main(String[] args) {

		// Creating a list of integers
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenList = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		List<Integer> oddList = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
		System.out.println(evenList);
		System.out.println(oddList);
		evenList.forEach(n->System.out.println(n));
	}
}
