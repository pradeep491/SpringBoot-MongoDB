package com.iib;

public class A {
	int speed;

	A() {
		System.out.println("speed is-" + speed);
	}

	{
		speed = 100;
		System.out.println("Instance Initializer block");
	}

	public static void main(String[] args) {
		A a = new A();
	}
}
