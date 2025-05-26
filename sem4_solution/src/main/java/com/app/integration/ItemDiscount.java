package com.app.integration;

public class ItemDiscount implements Discount {
	private double itemDiscountAmount;

	public ItemDiscount(double itemDiscount) {
		this.itemDiscountAmount = itemDiscount;
	}

	public double getDiscount() {
		return itemDiscountAmount;
	}
}
