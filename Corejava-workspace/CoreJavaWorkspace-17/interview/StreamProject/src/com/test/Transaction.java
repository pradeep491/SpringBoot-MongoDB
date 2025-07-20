package com.test;

import java.util.List;

public class Transaction {
	private List<Item> items;

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Transaction [items=" + items + "]";
	}
	
}
