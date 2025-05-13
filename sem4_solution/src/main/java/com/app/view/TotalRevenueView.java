package com.app.view;

import com.app.controller.*;
import com.app.integration.*;
import com.app.view.*;
import com.app.model.*;
import com.app.util.*;

class TotalRevenueView implements RevenueObserver {
    public double previousTotal;
    public double newTotal;
    
    public TotalRevenueView() {
        previousTotal = 0;
        newTotal = 0;
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
	 * and writes it to system out. 
	 *
	 * @param totalPrice is the number that is being added to the total revenue
	 * log file.
	 */
    public void addToRevenue(double totalPrice) {
        System.out.println("---------------------------------------");
        System.out.println("The prevoius total revenue was:      " + previousTotal + " SEK");
        System.out.println("The revenue from the latest sale is: " + totalPrice + " SEK");
        System.out.println("The new total revenue is:            " + addSaleToPreviousTotal(totalPrice) + " SEK");
        updatePreviousTotal();
    }
    
}