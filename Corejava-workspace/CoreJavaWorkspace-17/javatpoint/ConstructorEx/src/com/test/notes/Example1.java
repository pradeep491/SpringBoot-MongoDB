package com.test.notes;

public class Example1 {
int a,b;
Example1(){
	a=10;b=20;
	System.out.println(a);
	System.out.println(b);
}
public static void main(String[] args) {
	Example1 e1 = new Example1();
	Example1 e2 = new Example1();
}
}
