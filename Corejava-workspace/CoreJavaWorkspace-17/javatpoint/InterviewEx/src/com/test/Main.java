package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		for (int i = 0; i <= 10; i++) {
			if (i > 6)
				break;
		}
		//System.out.println(i);
		System.out.println(20/10%2);
		
		String str = "this is a java";
		String tokens[] = str.split(" ");
		System.out.println(tokens.length);
	}
}
