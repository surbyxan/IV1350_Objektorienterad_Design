package com.app.model;

import java.util.random;
import java.time.LocalDateTime;
/**
 * The sale class that 
 */
public class Sale {

	private Random rnd = new Random();
	
    private int cashierID;
    private int customerID;
    private int saleID;
	private LocalDateTime timeOfSale;
	private double runningVAT;
	private double runningItemPrice;
	private double runningTotal;
	private double runningItemCount;
    private double availableChange;



	public Sale(int cashierID, int customerID) {
		this.cashierID = cashierID;
		this.customerID = customerID;

		this.saleID = rnd.nextint(100);
        this.timeOfSale = LocalDateTime.now();
        // System.out.println(this.timeOfSale);

        this.runningVAT = 0;
        this.runningItemPrice = 0;
        this.runningTotal = 0;
        this.runningItemCount = 0;

        this.availableChange = getChange();
	}

	private static int getChange() { 
		//checkidouble change = 100; 
        double change = 100;
		return change; // in the model it says to return an int, but it is a double
	}

    public static boolean isItemInSale(int itemID){

    }
	
}