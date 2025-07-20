package com.test;

public class SingletonExample {
private static SingletonExample obj; 

private SingletonExample() {
	
}
private static SingletonExample getObj() {
	return obj;
}

public static void main(String[] args) {
	SingletonExample obj1 = SingletonExample.getObj();
}

}

