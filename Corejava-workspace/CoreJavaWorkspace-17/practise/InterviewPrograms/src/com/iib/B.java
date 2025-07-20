package com.iib;

class A1 {
	A1() {
		System.out.println("A1 class constructor");
	}
}

public class B extends A1 {
	B() {
		System.out.println("B class Constructor invoked...!");
	}

	{
		System.out.println("IIB Block from child class");
	}
	public static void main(String[] args) {
		B b = new B();
	}
}
