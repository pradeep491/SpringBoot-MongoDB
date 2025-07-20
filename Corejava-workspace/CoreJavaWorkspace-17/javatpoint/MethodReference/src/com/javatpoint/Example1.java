package com.javatpoint;

interface Sayable {
	void say();
}

public class Example1 {
	public static void saySomething() {
		System.out.println("Hello World...!");
	}

	public static void main(String[] args) {
		Sayable s = Example1::saySomething;
		s.say();
	}
}
