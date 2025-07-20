package com.test;

class BC {
	int a;

	void disp() {
		System.out.println("disp() method...!");
	}
}

public class DC extends BC {
	int b;

	void show() {
		a = 100;
		b = 200;
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {
		DC d1 = new DC();
		d1.show();
		d1.disp();
		BC bc = new BC();
		bc.disp();
	
	}
}
