package com.javatpoint;

interface Sayable {
	public String say();
}

public class Example3 {
	public static void main(String[] args) {
		Sayable s = () -> {
			return "hello Javatpoint";
		};
		System.out.println(s.say());
	}
}
