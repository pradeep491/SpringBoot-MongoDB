package com.javatpoint;

interface Drawable {
	void draw();
}

public class Example1 {
public static void main(String[] args) {
	int data=100;
	Drawable d = new Drawable() {
		public void draw() {
			System.out.println("data is-"+data);
		}
	};
	d.draw();
}
}
