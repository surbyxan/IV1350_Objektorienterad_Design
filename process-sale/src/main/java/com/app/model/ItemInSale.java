package com.app.model;

/**
 * 
 */
public class ItemInSale {

	private Item item;
	private int count;

	public ItemInSale(Item item) {
		this.item = item;
		this.count = 1;
	}

	public void increaseCount(){
		count += 1;
	}

	public int getCount(){
		return count;
	}

	public Item getItem(){
		return item;
	}
}