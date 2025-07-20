package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if (t % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
public static void main(String[] args) {
	Predicate<Integer> predicate = new PredicateEx();
	System.out.println(predicate.test(99));
	
	Predicate<Integer> predicate1 = (t)->{
		if (t % 2 == 0) {
			return true;
		} else {
			return false;
		}
	};
	System.out.println(predicate1.test(98));
	
	Predicate<Integer> predicate2 = t->t % 2 == 0;
	System.out.println(predicate2.test(233));
	
	List<Integer> list = Arrays.asList(1,2,3,4,5);
	list.stream().filter(predicate2).forEach(t ->System.out.println("print even:"+t));
}
}
