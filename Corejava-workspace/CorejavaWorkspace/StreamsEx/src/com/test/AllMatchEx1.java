package com.test;

import java.util.ArrayList;
import java.util.List;

public class AllMatchEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Java Tutorials");
		list.add("Python Tutorials");
		list.add("Spring Tutorials");
		list.add("Springboot Tutorials1");
		list.add("Jdbc Tutorials");

		boolean allMatch = list.stream().allMatch((value) -> {
			return value.contains("Tutorials");
		});
		System.out.println(allMatch);
	}
}
