package com.app.util;

import java.io.IOException;

public abstract class TotalRevenue implements RevenueObserver {

    private PrintWriter out;
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
	 * @param totalPriceOfLatestSale is the ammount from the latest sale that is 
     * being added to the total revenue
	 */
	public void addToRevenue ( double totalPriceOfLatestSale ) {
        previousTotal = newTotal;
        newTotal = newTotal + totalPriceOfLatestSale;

		showTotalIncome();
	}

	private void showTotalIncome () {
        String printThisString = new String (
             "\n---------------------------------------\nThe previous total revenue was:      "
             + previousTotal + " SEK\nThe revenue from the latest sale is: " + totalPrice + 
             " SEK\nThe new total revenue is:            " + addSaleToPreviousTotal(totalPrice) + 
             " SEK\n---------------------------------------\n");

		try {
			doShowTotalIncome (printThisString);
		} catch ( Exception e ) {
			handleErrors ( e );
		}
	}

    private double addSaleToPreviousTotal(double totalPrice) {
        newTotal = previousTotal + totalPrice;
        return newTotal; 
    }

    private void updatePreviousTotal() {
        previousTotal = newTotal;
    }

	protected abstract void handleErrors ( Exception e );

	protected abstract void doShowTotalIncome (String printThisString) throws Exception;
}