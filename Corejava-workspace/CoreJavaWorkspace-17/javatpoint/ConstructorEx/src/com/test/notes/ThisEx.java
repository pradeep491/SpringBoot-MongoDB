package com.test.notes;

public class ThisEx {
	int a, b;

	ThisEx(int a, int b) {
		this.a = a;
		this.b = b;
		a = a + 1;
		b = b + 1;
		this.a = this.a + 1;
		this.b = this.b + 2;
		System.out.println(a + " " + b);
	}

	void disp() {
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {
		ThisEx t1 = new ThisEx(10, 20);
		ThisEx t2 = new ThisEx(100, 200);
		t1.disp();
		t2.disp();
	}
}
