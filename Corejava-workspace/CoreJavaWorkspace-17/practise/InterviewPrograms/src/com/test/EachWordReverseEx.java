package com.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EachWordReverseEx {
	public static void main(String[] args) {
		String str = "java programming language";
		String result = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
