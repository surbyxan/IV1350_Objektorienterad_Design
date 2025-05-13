package com.app.util;

import java.io.*;
import com.app.util.*;

import com.app.util.RevenueObserver;

/**
 * Logs total revenue updates to a file named "revenue.txt" and
 * implements an observer to track and record revenue after each sale.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
	private PrintWriter logStream;
    public double previousTotal;
    public double newTotal;

	/**
	 * Constructs a TotalRevenueFileOutput object that initializes
	 * the revenue totals and sets up a PrintWriter to write revenue
	 * data to a file named "revenue.txt".
	 * If the file cannot be created or accessed, an error message is printed.
	 */
	public TotalRevenueFileOutput() {
		previousTotal = 0;
		newTotal = 0;
		try {
			logStream = new PrintWriter(new FileWriter("revenue.txt"), true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Writing revenue to file is not possible");
		}
	}

    private double addSaleToPreviousTotal(double totalPrice) {
        newTotal = previousTotal + totalPrice;
        return newTotal; 
    }

    private void updatePreviousTotal() {
        previousTotal = newTotal;
    }

	/**
	 * Updates the total revenue that the program has processed
	 * and writes it to a file. 
	 *
	 * @param totalPrice is the number that is being added to the total revenue
	 * log file.
	 */
	public void addToRevenue(double totalPrice) {
        logStream.println("\n---------------------------------------");
        logStream.println("The previous total revenue was:      " + previousTotal + " SEK");
        logStream.println("The revenue from the latest sale is: " + totalPrice + " SEK");
        logStream.println("The new total revenue is:            " + addSaleToPreviousTotal(totalPrice) + " SEK");
        logStream.println("---------------------------------------\n");
        updatePreviousTotal();
	}

}
