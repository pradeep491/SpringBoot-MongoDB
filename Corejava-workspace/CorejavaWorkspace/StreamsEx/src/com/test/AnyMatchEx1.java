package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class AnyMatchEx1 {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<String>();

		stringList.add("Java Guides");
		stringList.add("Python Guides");
		stringList.add("C Guides");
		stringList.add("hello");
		
		Stream<String> stream = stringList.stream();

		boolean anyMatch = stream.anyMatch((value) -> {
			return value.startsWith("Hello");
		});
		System.out.println(anyMatch);
	}
}
