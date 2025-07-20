package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	
	public static void main(String[] args) {
		/*
		 * Consumer<Integer> consumer = t ->System.out.println("printing :"+t);
		 * consumer.accept(100);
		 */
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.stream().forEach(t ->System.out.println("print :"+t));
	}
}
