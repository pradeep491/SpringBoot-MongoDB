package com.javatpoint;

interface Drawable1 {
	public void draw();
}

public class Example2 {
	public static void main(String[] args) {
		int data = 200;
		Drawable1 d = () -> {
			System.out.println("data is-" + data);
		};
		d.draw();
	}
}
