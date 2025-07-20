package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Example {

	public static void main(String[] args) {
		String inputString = "Java Concept Of The Day";
		Map<Character, Long> map = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(map);

		// String count

		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler",
				"Note Book", "Pencil");
		Map<String, Long> map1 = stationeryList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map1);
	}

}
