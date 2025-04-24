package com.app.integration;

public class DiscountCollectionDTO {

	private double itemDiscount;
	private double priceDiscountPercentage;
	private double customerDiscountPercentage;

	public DiscountCollectionDTO(double itemDiscount, double priceDiscountPercentage, double customerDiscountPercentage) {
		this.itemDiscount = itemDiscount;
		this.priceDiscountPercentage = priceDiscountPercentage;
		this.customerDiscountPercentage = customerDiscountPercentage;

	}

	public double getItemDiscount() {
		return itemDiscount;
	}

	public double getPriceDiscountPercentage() {
		return priceDiscountPercentage;
	}

	public double getCustomerDiscountPercentage() {
		return customerDiscountPercentage;
	}
}
