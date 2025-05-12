package com.app.integration;

import com.app.integration.*;

/**
 * A data transfer object (DTO) representing an item included in a sale,
 * along with the quantity of that item.
 */
public class ItemInSaleDTO {

	private ItemDTO itemDTO;
	private int count;

	/**
     * Creates a new {@code ItemInSaleDTO} with the specified item data and quantity.
     *
     * @param itemDTO the DTO representing the item
     * @param count the number of times the item has been added to the sale
     */
	public ItemInSaleDTO(ItemDTO itemDTO, int count) {
		this.itemDTO = itemDTO;
		this.count = count;
	}

	/**
	 * Increases the number of an item in the sale.
	 */
	public void increaseCount(){
		count += 1;
	}

	/**
	 * Getter for the number of times an item has been added to the sale
	 * @return the number of times an item has been aded to the sale
	 */
	public int getCount(){
		return count;
	}

	/**
	 * Getter for the item DTO
	 * @return the item DTO
	 */
	public ItemDTO getItemDTO() {
		return itemDTO;
	}

	/**
	 * Getter for the item description as a string.
	 * 
	 * @return the item description as a string
	 */
	public String getString(){
		return itemDTO.getDescription();
	}
}