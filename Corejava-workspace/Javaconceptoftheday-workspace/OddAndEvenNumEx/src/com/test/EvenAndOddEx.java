package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class EvenAndOddEx {
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

		Map<Boolean, List<Integer>> map = listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

		Set<Entry<Boolean, List<Integer>>> set = map.entrySet();
		for (Entry<Boolean, List<Integer>> entry : set) {

			if (entry.getKey()) {
				System.out.println("Even Numbers...!");
			} else {
				System.out.println("Odd Numbers...!");
			}
			List<Integer> list = entry.getValue();
			list.stream().forEach(System.out::println);
		}
	}
}
