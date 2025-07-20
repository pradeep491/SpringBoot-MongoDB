package com.javatpoint;

interface Addable {
	int add(int a, int b);
}

public class Example4 {
	public static void main(String[] args) {
		Addable a1 = (a, b) -> {
			return a + b;
		};
		System.out.println(a1.add(30, 70));
		Addable a2 = (a, b) -> (a + b);
		System.out.println(a2.add(23, 21));
	}
}
