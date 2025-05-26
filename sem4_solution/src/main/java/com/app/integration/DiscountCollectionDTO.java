package com.app.integration;

import main.java.com.app.integration.ItemDiscount;

/**
 * The class responsible for gathering all discounts that can be applied to the sale.
 */
public class DiscountCollectionDTO {

	private ItemDiscount itemDiscount;
	private PriceDiscount priceDiscount;
	private CustomerDiscount customerDiscount;

	/**
	 * Creates a new discount collection containing item, price, and customer discounts.
	 *
	 * @param itemDiscount the discount for the list of items
	 * @param priceDiscount the percentage discount based on the total price
	 * @param customerDiscount the percentage discount fot the speciffic customer
	 */
	public DiscountCollectionDTO(ItemDiscount itemDiscount, PriceDiscount priceDiscount, CustomerDiscount customerDiscount) {
		this.itemDiscount = itemDiscount;
		this.priceDiscount = priceDiscount;
		this.customerDiscount = customerDiscount;

	}

	/**
	 * Getter for the discount from the items in the sale.
	 * 
	 * @return the discounts for the items
	 */
	public double getItemDiscountAmount() {
		return itemDiscount.getDiscount();
	}

	/**
	 * Getter for the discount percentage from the total price of the sale.
	 * 
	 * @return the discount percentage from the total price
	 */
	public double getPriceDiscountPercentage() {
		return priceDiscountPercentage.getDiscount();
	}

	/**
	 * Getter for the discount percentage that the customer is eligable for.
	 * 
	 * @return the discount percentage the customer is eligable for
	 */
	public double getCustomerDiscountPercentage() {
		return customerDiscountPercentage.getDiscount();
	}
}
