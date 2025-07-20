package com.javatpoint;

import java.util.ArrayList;
import java.util.List;

public class Example5 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("kumar");
		list.add("kumari");
		list.add("test1");
		list.add("test2");

		list.forEach(n -> System.out.println(n));
	}
}
