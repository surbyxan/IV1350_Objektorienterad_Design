package com.app.model;

import com.app.integration.*;

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

	public void increaseCount() {
		count += 1;
	}

	public int getCount() {
		return count;
	}

	// public Item getItem(){
	// return item;
	// }


	public ItemInSaleDTO getItemInSaleDTO() {
		return new ItemInSaleDTO(new ItemDTO(item), count);
	}
}