package com.test;

public class Item {
	public Integer itemId;

	public Item(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getItemId() {
		return itemId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + "]";
	}
	
}
