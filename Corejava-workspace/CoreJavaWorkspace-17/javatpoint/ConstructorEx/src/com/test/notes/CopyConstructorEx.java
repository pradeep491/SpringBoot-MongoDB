package com.test.notes;

public class CopyConstructorEx {
	int a, b;

	public CopyConstructorEx() {
		a = 10;
		b = 20;
		System.out.println(a + " " + b);
	}

	public CopyConstructorEx(int x) {
		a = b = x;
		System.out.println(a + " " + b);
	}

	public CopyConstructorEx(int x, int y) {
		a = x;
		b = y;
		System.out.println(a + " " + b);
	}

	public CopyConstructorEx(CopyConstructorEx e) {
		a = e.a;
		b = e.b;
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {
		CopyConstructorEx c1 = new CopyConstructorEx();
		CopyConstructorEx c2 = new CopyConstructorEx(10);
		CopyConstructorEx c3 = new CopyConstructorEx(30, 40);
		CopyConstructorEx c4 = new CopyConstructorEx(c3);

	}
}
