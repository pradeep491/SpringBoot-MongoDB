package com.test;

import java.util.Scanner;

public class SumOfDigitsEx {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Number");
		String number = s.nextLine();
		s.close();
		int sum = number.chars().map(Character::getNumericValue).sum();
		System.out.println(sum);
	}
}
