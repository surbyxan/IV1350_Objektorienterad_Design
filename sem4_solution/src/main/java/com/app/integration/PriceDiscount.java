package com.app.integration;

/**
 * This is the object that instansiate the discount of a whole sale
 * It is created in the discount factory and implements the discount interface.
 */
public class PriceDiscount implements Discount{
	private double priceDiscountPercentage;	

	/**
	 * The method sets the percentage value of a discount of the whole sale.
	 * 
	 * @param priceDiscount the percentage discount which the discound object should contain.
	 */
	public PriceDiscount(double priceDiscount) {
		this.priceDiscountPercentage = priceDiscount;
	}

	/**
	 * Getter for the discount percentage.
	 * 
	 * @return the discount percentage of a price type.
	 */
	public double getDiscount() {
		return priceDiscountPercentage;
	}
}
