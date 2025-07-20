package com.javatpoint;

public class Adder {
	static int add(int a, int b) {
		return a + b;
	}

	static int add(int a, int b, int c) {
		return a + b + c;
	}
	static double add(double a , double b) {
		return a + b ;
	}

	public static void main(String[] args) {
		System.out.println(Adder.add(10, 20));
		System.out.println(Adder.add(10, 20, 30));
		System.out.println(Adder.add(10.5, 11.5));
	}
}
