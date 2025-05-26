package com.app.integration;

public class PriceDiscount implements Discount{
	private double priceDiscountPercentage;

	public PriceDiscount(double priceDiscount) {
		this.priceDiscountPercentage = priceDiscount;
	}

	public double getDiscount() {
		return priceDiscountPercentage;
	}
}
