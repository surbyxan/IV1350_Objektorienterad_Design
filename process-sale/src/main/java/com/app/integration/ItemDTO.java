
package com.app.integration;

import com.app.model.*;

/**
 * A DTO representing an item, including its ID, description, price, and VAT
 * price used
 * to transfer item data between system layers without exposing internal logic.
 */
public class ItemDTO {
	public int itemID;
	private String itemDescription;
	private double itemPrice;
	private double itemVATPrice;

	/**
	 * Creates a new {@code ItemDTO} with the specified values.
	 *
	 * @param itemID          the unique identifier of the item
	 * @param itemDescription a short description of the item
	 * @param itemPrice       the base price of the item (excluding VAT)
	 * @param itemVATPrice    the VAT amount for the item
	 */
	public ItemDTO(int itemID, String itemDescription, double itemPrice, double itemVATPrice) {
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemVATPrice = itemVATPrice;
	}

	/**
	 * Creates a new {@code ItemDTO} from an {@code Item} object.
	 *
	 * @param item the object representing the item
	 */
	public ItemDTO(Item item) {
		this.itemID = item.getID();
		this.itemDescription = item.getDescription();
		this.itemPrice = item.getPrice();
		this.itemVATPrice = item.getVATPrice();
	}

	public int getID() {
		return this.itemID;
	}

	public String getDescription() {
		return this.itemDescription;
	}

	public double getPrice() {
		return this.itemPrice;
	}

	public double getVATPrice() {
		return this.itemVATPrice;
	}
}