package com.app.util;

import java.io.*;
import com.app.util.*;

public class TotalRevenueFileOutput implements RevenueObserver {
	private PrintWriter logStream;
    public double previousTotal;
    public double newTotal;

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
		// todo previous total needs updating
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
        logStream.println("---------------------------------------");
        logStream.println("The prevoius total revenue was:      " + previousTotal + " SEK");
        logStream.println("The revenue from the latest sale is: " + totalPrice + " SEK");
        logStream.println("The new total revenue is:            " + addSaleToPreviousTotal(totalPrice) + " SEK");
        updatePreviousTotal();
	}

}
