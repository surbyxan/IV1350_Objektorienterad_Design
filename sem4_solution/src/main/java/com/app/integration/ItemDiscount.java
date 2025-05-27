package com.app.integration;

/**
 * This is the object that instantiate the discount type of certain items. 
 * It is created in the discount factory and implements the discount interface.
 */
public class ItemDiscount implements Discount {
	private double itemDiscountAmount;

	/**
	 * This is the constructor for the item discount object.
	 * 
	 * @param itemDiscount is the value it recives from the discount database.
	 */
	public ItemDiscount(double itemDiscount) {
		this.itemDiscountAmount = itemDiscount;
	}

	/**
	 * This is a getter for the discount that is applied.
	 * 
	 * @return the given discount for items.
	 */
	public double getDiscount() {
		return itemDiscountAmount;
	}
}
