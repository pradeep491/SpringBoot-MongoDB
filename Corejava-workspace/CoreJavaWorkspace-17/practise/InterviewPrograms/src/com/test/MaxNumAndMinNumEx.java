package com.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxNumAndMinNumEx {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,13,14);
		OptionalInt max = list.stream().mapToInt(Integer::intValue).max();
		OptionalInt min = list.stream().mapToInt(Integer::intValue).min();
		
		max.ifPresent(m->System.out.println(m));
		min.ifPresent(m->System.out.println(m));
		
		//second Largest number
		Optional<Integer> secondMax = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		secondMax.ifPresent(n->System.out.println(n));
	}
}
