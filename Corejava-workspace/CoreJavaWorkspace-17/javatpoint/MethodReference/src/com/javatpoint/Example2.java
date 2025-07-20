package com.javatpoint;

public class Example2 {
	public static void ThreadStatus() {
		System.out.println("Thread is running...!");
	}
	public static void main(String[] args) {
		Thread t = new Thread(Example2::ThreadStatus);
		t.start();
	}
}
