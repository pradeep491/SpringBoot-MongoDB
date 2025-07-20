package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example {
	public static void main(String[] args) {
		List<String> str = Arrays.asList("1", "2", "3");
		List<Integer> list = str.stream().map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(list);
	}
}
