package com.test;

class BC2 {
	void disp() {
		System.out.println("base disp()");
	}
}

class DC2 extends BC2 {
	void disp() {
		super.disp();
		System.out.println("derived disp()");
	}
}

public class SuperEx2 {
	public static void main(String[] args) {
		DC2 d = new DC2();
		d.disp();
	}

}
