package com.app.model;

import com.app.integration.*;

/**
 * The method that creates items that represents different items in the sale. Is created on "addItem"
 */
public class Item {

	public int itemID;
	private String itemDescription;
	private double itemPrice;
	private double itemVATPrice;

	/**
	 * Constructs an {@code Item} using data from an {@code ItemDTO}.
	 * @param item The {@code ItemDTO} containing item data.
	 */
	public Item(ItemDTO item) {
		this.itemID = item.getID();
		this.itemDescription = item.getDescription();
		this.itemPrice = item.getPrice();
		this.itemVATPrice = item.getVATPrice();
	}

	/**
	 * Returns the unique ID of the item.
	 * @return The item ID.
	 */
	public int getID() {
		return this.itemID;
	}

	/**
	 * Returns the textual description of the item.
	 * @return The item description.
	 */
	public String getDescription() {
		return this.itemDescription;
	}

	/**
	 * Returns the price of the item (excluding VAT).
	 * @return The item price.
	 */
	public double getPrice() {
		return this.itemPrice;
	}

	/**
	 * Returns the VAT (Value-Added Tax) amount for the item.
	 * @return The item's VAT amount.
	 */
	public double getVATPrice() {
		return this.itemVATPrice;
	}
}
