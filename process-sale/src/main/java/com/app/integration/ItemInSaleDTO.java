package com.app.integration;

import com.app.integration.*;
/**
 * 
 */
public class ItemInSaleDTO {

	private ItemDTO itemDTO;
	private int count;

	public ItemInSaleDTO(ItemDTO itemDTO, int count) {
		this.itemDTO = itemDTO;
		this.count = count;
	}


	public void increaseCount(){
		count += 1;
	}

	public int getCount(){
		return count;
	}

	// public Item getItem(){
	// 	return item;
	// }


	public ItemDTO getItemDTO() {
		return itemDTO;

	}
}