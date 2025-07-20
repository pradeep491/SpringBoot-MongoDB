package com.test;

import java.util.stream.Collectors;

public class FrequenctOfChars {
	public static void main(String[] args) {

		String str = "pradeep kumar kandyala";

		str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()))
				.forEach((character, frequency) -> System.out.println(character + ":" + frequency));

	
	
	
	}
}

