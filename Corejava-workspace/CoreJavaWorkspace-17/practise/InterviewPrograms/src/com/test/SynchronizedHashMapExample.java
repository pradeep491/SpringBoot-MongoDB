package com.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SynchronizedHashMapExample {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("ONE", 1);
		map.put("TWO", 2);
		map.put("THREE", 3);
		map.put("FOUR", 4);
		map.put("FIVE", 5);

		Map<String, Integer> synchronizedMap = Collections.synchronizedMap(map);
		Set<String> keySet = synchronizedMap.keySet();
		System.out.println("Keys.............");
		synchronized (synchronizedMap) {
			Iterator<String> it = keySet.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}

		Collection<Integer> values = synchronizedMap.values();
		System.out.println("Values.............");
		synchronized (synchronizedMap) {
			Iterator<Integer> it = values.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
		}
	}
}
