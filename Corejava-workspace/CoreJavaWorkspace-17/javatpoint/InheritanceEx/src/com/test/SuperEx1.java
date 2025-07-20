package com.test;

class BC1 {
	int a;
}

class DC1 extends BC1 {
	int a, c;

	void set(int x, int y) {
		super.a = x;
		this.a = y;
	}

	void sum() {
		c = super.a + a;
	}

	void disp() {
		System.out.println(super.a);
		System.out.println(this.a);
		System.out.println("sum-" + c);
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		DC1 d = new DC1();
		d.set(20, 40);
		d.sum();
		d.disp();
	}
}
