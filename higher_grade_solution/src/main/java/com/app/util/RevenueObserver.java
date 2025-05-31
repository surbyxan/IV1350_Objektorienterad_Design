package com.app.util;

// import com.app.view.*;

/**
 *  This listener interface is listening for updates in the
 *  stores total revenue. The class that is interested in such
 *  updated implements this interface, and the object
 *  created with that class is registered with 
 *  When a sale has ended, that sale's total price
 *  is stored and the observer is implemented
 */
public interface RevenueObserver {

	/**
	 * Invoked when a sale has ended 
	 * 
	 * @param totalPrice is the number that is being added to the total revenue
	 */
	void addToRevenue(double totalPrice);
}
