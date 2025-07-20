package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachEx {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");

		list.stream().forEach(t -> System.out.println(t));

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		map.put(4, "d");

		map.forEach((key, value) -> System.out.println(key + ":" + value));
		map.entrySet().stream().forEach(obj->System.out.println(obj));
		
		Consumer<String> consumer = (t)->System.out.println(t);
		consumer.accept("pradeep");
		
		//list.forEach(consumer);
	}
}
