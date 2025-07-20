package com.test;

import java.util.Arrays;
import java.util.List;

public class MultiplyEx {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		int number = list.stream().reduce(1,(a,b)->a*b).intValue();
		System.out.println(number);
	}
}
