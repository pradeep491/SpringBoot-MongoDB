package com.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class NonRepeatedCharacterFinder {
	public static void main(String[] args) {
		String str = "Java Guides";
		char ch = firstNonRepeatedChar(str);
		if (ch != '\0') {
			System.out.println("first non repeated character is:" + ch);
		} else {
			System.out.println("all characters are repeated...!");
		}
	}

	public static char firstNonRepeatedChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		for (char ch : str.toCharArray()) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return '\0';
	}
}
