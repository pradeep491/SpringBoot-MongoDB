package com.javatpoint;

public class Example2 {
	void sum(int a, int b) {
		System.out.println("int arg method invoked");
	}

	void sum(long a, long b) {
		System.out.println("long arg method invoked");
	}

	public static void main(String args[]) {
		Example2 obj = new Example2();
		obj.sum(20, 20);
	}
}
