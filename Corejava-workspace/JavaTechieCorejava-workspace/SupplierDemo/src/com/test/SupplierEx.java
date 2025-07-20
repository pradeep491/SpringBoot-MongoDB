package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierEx /* implements Supplier<String> */{

	/*
	 * @Override public String get() { return "hello pradeep"; }
	 */
public static void main(String[] args) {
	/*
	 * Supplier<String> supplier = new SupplierEx();
	 * System.out.println(supplier.get());
	 */
	Supplier<String> supplier1 = ()->{
		return "hello pradeep1";
	};
	System.out.println(supplier1.get());
	
	Supplier<String> supplier2 = ()->
		"hello pradeep2";
	System.out.println(supplier2.get());
	
	List<String> list = Arrays.asList("A","B");
	System.out.println(list.stream().findAny().orElseGet(supplier2));
	System.out.println(list.stream().findAny().orElseGet(()->
	"test pradeep2"));
}
}
