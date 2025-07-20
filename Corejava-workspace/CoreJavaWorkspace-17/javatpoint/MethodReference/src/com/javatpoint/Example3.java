package com.javatpoint;

import java.util.function.BiFunction;

public class Example3 {
	public static int add(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder = Example3::add;
		int result = adder.apply(10, 20);
		System.out.println(result);
	}
}
