package com.app.integration;

import com.app.integration.ItemDiscount;

/**
 * The class responsible for gathering all discounts that can be applied to the sale.
 */
public class DiscountCollectionDTO {

	private Discount itemDiscount;
	private Discount priceDiscount;
	private Discount customerDiscount;

	/**
	 * Creates a new discount collection containing item, price, and customer discounts.
	 *
	 * @param itemDiscount the discount for the list of items
	 * @param priceDiscount the percentage discount based on the total price
	 * @param customerDiscount the percentage discount fot the speciffic customer
	 */
	public DiscountCollectionDTO(Discount itemDiscount, Discount priceDiscount, Discount customerDiscount) {
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
		return priceDiscount.getDiscount();
	}

	/**
	 * Getter for the discount percentage that the customer is eligable for.
	 * 
	 * @return the discount percentage the customer is eligable for
	 */
	public double getCustomerDiscountPercentage() {
		return customerDiscount.getDiscount();
	}
}
