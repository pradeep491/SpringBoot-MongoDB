package com.test;

public class AnonymousFunctionEx {
	public void m1() {
		System.out.println("Normal Method/Function");
	}

	/*
	 * (){ System.out.println("Ananymous Method/Function"); }
	 */

	public static void main(String[] args) {
		new AnonymousFunctionEx().m1();

	}

}
