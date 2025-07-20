package com.test;

class BC3 {
	void op(int x, int y) {
		System.out.println("base class op()");
		int k = x + y;
		System.out.println("sum in base-" + k);
	}
}

class IBC3 extends BC3 {
	void op(int x, int y) {
		super.op(x, y);
		System.out.println("intermediate derived class");
		int k = x - y;
		System.out.println("sub-" + k);
	}
}

class DC3 extends IBC3 {
	void op(int x, int y) {
		super.op(x, y);
		System.out.println("Derived class op()");
		int k = x * y;
		System.out.println("multiply-" + k);
	}
}

public class SuperEx3 {
	public static void main(String[] args) {
		DC3 d = new DC3();
		d.op(40, 30);
	}
}
