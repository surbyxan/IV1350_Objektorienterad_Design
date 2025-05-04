package com.app.model;

import com.app.integration.*;

/**
 * Represents an item that has been added to a sale, along with the quantity of that item.
 */
public class ItemInSale {

	private Item item;
	private int count;

	/**
	 * Constructs a new {@code ItemInSale} object with an initial count of 1.
	 * @param item The {@code Item} being added to the sale.
	 */
	public ItemInSale(Item item) {
		this.item = item;
		this.count = 1;
	}

	/**
	 * Increases the count (quantity) of this item in the sale by 1.
	 */
	public void increaseCount() {
		count += 1;
	}

	/**
	 * Returns the number of times this item has been added to the sale.
	 * @return The current item count.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Returns the {@code Item} associated with this {@code ItemInSale}.
	 * @return The original {@code Item} object.
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * Creates and returns a data transfer object ({@code ItemInSaleDTO})
	 * that represents this item and its quantity in the sale.
	 * @return A DTO representing the item and its quantity.
	 */
	public ItemInSaleDTO getItemInSaleDTO() {
		return new ItemInSaleDTO(new ItemDTO(item), count);
	}
}
