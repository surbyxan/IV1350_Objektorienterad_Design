package com.app.integration;

public class CustomerDiscount implements Discount {
	private double discountPercentage;

	public CustomerDiscount(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public double getDiscount() {
		return discountPercentage;
	}
}
