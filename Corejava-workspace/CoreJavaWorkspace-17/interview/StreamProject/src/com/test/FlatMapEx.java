package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapEx {
	public static void main(String[] args) {
		List<Transaction> transactions = new ArrayList();
		List<Item> items = new ArrayList();
		items.add(new Item(123));
		items.add(new Item(223));
		items.add(new Item(123));
		items.add(new Item(423));
		items.add(new Item(123));
		Transaction transaction = new Transaction();
		transaction.setItems(items);
		Transaction transaction2 = new Transaction();
		transaction2.setItems(Arrays.asList(new Item(123)));
		transactions.add(transaction);
		transactions.add(transaction2);
		System.out.println(transactions);
// write the code in java8 steams
		List<Item> items1 = transactions.stream().flatMap(item -> item.getItems().stream()).collect(Collectors.toList());
		System.out.println(items1);
		
		//items1.stream().flatMap(a->a.getItemId);
	}
}
