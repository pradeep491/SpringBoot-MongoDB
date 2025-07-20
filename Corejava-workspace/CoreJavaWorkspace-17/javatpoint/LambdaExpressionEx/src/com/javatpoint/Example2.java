package com.javatpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Example2 {
	public static void main(String[] args) {
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Samsung A5", 17000d));
		list.add(new Product(3, "Iphone 6S", 65000d));
		list.add(new Product(2, "Sony Xperia", 25000d));
		list.add(new Product(4, "Nokia Lumia", 15000d));
		list.add(new Product(5, "Redmi4 ", 26000d));
		list.add(new Product(6, "Lenevo Vibe", 19000d));

		Stream<Product> filterd_data = list.stream().filter(p -> p.price > 10000);
		filterd_data.forEach(product -> System.out.println(product.pname + "-" + product.price));

	}
}
