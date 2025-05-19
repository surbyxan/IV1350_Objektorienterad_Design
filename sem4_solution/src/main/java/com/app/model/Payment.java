package com.app.model;
import java.util.ArrayList;
import java.util.List;
import com.app.util.*;

import com.app.view.*;


/**
 * Represents a payment made for a sale, including total price, 
 * the amount paid by the customer, and the change to return.
 */
public class Payment {

	private double totalPrice;
	private double amountPaid;
	private double changeBack;
	private List<RevenueObserver> observers;

	/**
	 * Constructs a new Payment object with the specified total price.
	 *
	 * @param totalPrice The total price of the sale.
	 */
	public Payment(double totalPrice) {
		this.totalPrice = totalPrice;
		this.amountPaid = 0;
		this.changeBack = 0;
		this.observers = new ArrayList<>();
	}

	public void addObserver(RevenueObserver observer) {
        observers.add(observer);
    }

	private void notifyObservers() {
		for (RevenueObserver observer : observers) {
            observer.addToRevenue(totalPrice);
        }
	}

	public void finalizePayment() {
		notifyObservers();
	}

	/**
	 * Gets the total price of the sale.
	 *
	 * @return The total price.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Gets the amount paid by the customer.
	 *
	 * @return The amount the customer has paid.
	 */
	public double getAmountPaid() {
		return amountPaid;
	}

	/**
	 * Gets the amount of change to return to the customer.
	 *
	 * @return The change to give back to the customer.
	 */
	public double getChangeBack() {
		return changeBack;
	}

	/**
	 * Sets the amount paid by the customer.
	 *
	 * @param amountPaid The amount the customer has paid.
	 */
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid; // Fixed: assigns to the class field
	}

	/**
	 * Sets the amount of change to return to the customer.
	 *
	 * @param changeBack The change to give back to the customer.
	 */
	public void setChangeBack(double changeBack) {
		this.changeBack = changeBack; // Fixed: assigns to the class field
	}
}
