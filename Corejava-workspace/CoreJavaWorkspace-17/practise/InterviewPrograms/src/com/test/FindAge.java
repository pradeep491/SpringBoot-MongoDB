package com.test;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class FindAge {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the DOB(YYYY-MM-DD:)");
		String birthDate = s.nextLine();
		s.close();

		LocalDate birth = LocalDate.parse(birthDate);
		LocalDate now = LocalDate.now();
		Period gap = Period.between(birth, now);
		System.out.println("you are " + gap.getYears() + " years old...!");
	}
}
