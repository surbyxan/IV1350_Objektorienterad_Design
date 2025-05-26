package com.app.util;

import java.io.*;
import java.io.IOException;

public abstract class TotalRevenue implements RevenueObserver {

    public PrintWriter out;
    public double previousTotal;
    public double newTotal;


	/**
	 * Constructs a TotalRevenue object that initializes
	 * the revenue totals.
	 */
	public TotalRevenue() {
		previousTotal = 0;
		newTotal = 0;
    }

	/**
	 * Updates the total revenue that the program has processed since it started
	 *
	 * @param totalPrice is the ammount from the latest sale that is 
     * being added to the total revenue
	 */
	@Override
	public void addToRevenue ( double totalPrice ) {
        previousTotal = newTotal;
        newTotal = newTotal + totalPrice;

		showTotalIncome(totalPrice);
	}

	private void showTotalIncome (double totalPrice) {
        String printThisString = new String (
             "\n----------------- REVENUE -----------------\nThe previous total revenue was:      "
             + previousTotal + " SEK\nThe revenue from the latest sale is: " + totalPrice + 
             " SEK\nThe new total revenue is:            " + newTotal + 
             " SEK\n-------------------------------------------\n");

		try {
			doShowTotalIncome (printThisString);
		} catch ( Exception e ) {
			handleErrors ( e );
		}
	}

	protected abstract void handleErrors ( Exception e );

	protected abstract void doShowTotalIncome (String printThisString) throws Exception;
}