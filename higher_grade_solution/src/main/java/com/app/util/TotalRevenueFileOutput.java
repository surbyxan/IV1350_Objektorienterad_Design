package com.app.util;

import java.io.*;
import com.app.util.*;


/**
 * Logs total revenue updates to a file named "revenue.txt" 
 */
public class TotalRevenueFileOutput extends TotalRevenue {

	/**
	 * Constructs a TotalRevenueFileOutput object that 
	 * sets up a PrintWriter to write revenue
	 * data to a file named "revenue.txt".
	 * If the file cannot be created or accessed, an error message is printed.
	 */
	public TotalRevenueFileOutput() {
		try {
			out = new PrintWriter(new FileWriter("revenue.txt"), true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Writing revenue to file is not possible");
		}
	}

	/**
	 * Writes the prepared total revenue to a file. 
	 *
	 * @param printThisString is the string to be printed to the Log file
	 */
	@Override
	public void doShowTotalIncome(String printThisString) {
		out.println(printThisString);
	}

    /**
     * Handles exceptions that is thrown when observer tries to print.
     * 
     * @param e the exception to be handled.
     */
	@Override
	public void handleErrors (Exception e) {
		e.printStackTrace();
	}

}
