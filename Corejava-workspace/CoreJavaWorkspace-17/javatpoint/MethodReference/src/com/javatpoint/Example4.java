package com.javatpoint;

import java.util.function.BiFunction;

public class Example4 {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(int a, float b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> adder = Example4::add;
		BiFunction<Integer, Float, Float> adder1 = Example4::add;
		BiFunction<Float, Float, Float> adder2 = Example4::add;
		int result1 = adder.apply(30,24);
		float result2 = adder1.apply(30,24.5f);
		float result3 = adder2.apply(30.2f,24.1f);
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
	}
}
