package com.javatpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortBasedOnName {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Samsung A5", 17000d));
		list.add(new Product(3, "Iphone 6S", 65000d));
		list.add(new Product(2, "Sony Xperia", 25000d));
		list.add(new Product(4, "Nokia Lumia", 15000d));
		list.add(new Product(5, "Redmi4 ", 26000d));
		list.add(new Product(6, "Lenevo Vibe", 19000d));

		System.out.println("Sorting on basis name");
		Collections.sort(list, (p1, p2) -> {
			return p1.pname.compareTo(p2.pname);
		});
		for (Product p : list) {
			System.out.println(p.pid + " " + p.pname + " " + p.price);
		}
	}

}
