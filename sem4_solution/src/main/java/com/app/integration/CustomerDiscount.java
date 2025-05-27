package com.app.integration;

/**
 * This is the object that instantiate the discount type of a customer. 
 * It is created in the discount factory and implements the discount interface.
 */
public class CustomerDiscount implements Discount {
	private double discountPercentage;

	/**
	 * The method sets the percentage value of a discount of the customer type.
	 * 
	 * @param discountPercentage the percentage discount which the discound object should contain.
	 */
	public CustomerDiscount(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	/**
	 * Getter for the discount percentage.
	 * 
	 * @return the discount percentage of a customer type.
	 */
	public double getDiscount() {
		return discountPercentage;
	}
}
