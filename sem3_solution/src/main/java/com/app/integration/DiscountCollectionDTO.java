package com.app.integration;

/**
 * The class responsible for gathering all discounts that can be applied to the sale.
 */
public class DiscountCollectionDTO {

	private double itemDiscount;
	private double priceDiscountPercentage;
	private double customerDiscountPercentage;

	/**
	 * Creates a new discount collection containing item, price, and customer discounts.
	 *
	 * @param itemDiscount the discount for the list of items
	 * @param priceDiscountPercentage the percentage discount based on the total price
	 * @param customerDiscountPercentage the percentage discount fot the speciffic customer
	 */
	public DiscountCollectionDTO(double itemDiscount, double priceDiscountPercentage, double customerDiscountPercentage) {
		this.itemDiscount = itemDiscount;
		this.priceDiscountPercentage = priceDiscountPercentage;
		this.customerDiscountPercentage = customerDiscountPercentage;

	}

	/**
	 * Getter for the discount from the items in the sale.
	 * 
	 * @return the discounts for the items
	 */
	public double getItemDiscount() {
		return itemDiscount;
	}

	/**
	 * Getter for the discount percentage from the total price of the sale.
	 * 
	 * @return the discount percentage from the total price
	 */
	public double getPriceDiscountPercentage() {
		return priceDiscountPercentage;
	}

	/**
	 * Getter for the discount percentage that the customer is eligable for.
	 * 
	 * @return the discount percentage the customer is eligable for
	 */
	public double getCustomerDiscountPercentage() {
		return customerDiscountPercentage;
	}
}
