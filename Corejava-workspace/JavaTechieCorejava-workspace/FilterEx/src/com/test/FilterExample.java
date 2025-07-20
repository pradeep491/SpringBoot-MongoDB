package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.add("sest5");
		
		/*
		 * for(String s: list) { 
		 * if(s.startsWith("t")) {
		 *  System.out.println(s); 
		 *  } 
		 * }
		 */
		
		list.stream().filter((s)->s.startsWith("s")).forEach(t->System.out.println(t));
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");
		map.entrySet().stream().filter(k->k.getKey()%2==0).forEach(obj->System.out.println(obj));
	}

}
