package com.app.view;

import com.app.controller.*;
import com.app.integration.*;
import com.app.view.*;
import com.app.util.*;



import com.app.model.*;
import com.app.util.*;

public class TotalRevenueView extends TotalRevenue {
    
    public TotalRevenueView() {
    }

	/**
	 * Writes the total revenue to system out. 
	 *
	 * @param printThisString is the string that will show the updated revenue
	 */
    @Override
    public void doShowTotalIncome(String printThisString) {
       System.out.println(printThisString);
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