package com.javatpoint;

public class Calculate {
	int a = 15;
	static int cube(int n) {
		return n * n * n;
	}

	public static void main(String[] args) {
		System.out.println(Calculate.cube(5));
		System.out.println(new Calculate().a);
	}
}
