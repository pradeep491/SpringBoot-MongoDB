package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateNumbersList {
	public static void main(String[] args) {

		List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10);

		System.out.println(numbersWithDuplicates);

		List<Integer> numbersWithOutDuplicates = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
		System.out.println(numbersWithOutDuplicates);
	}
}
