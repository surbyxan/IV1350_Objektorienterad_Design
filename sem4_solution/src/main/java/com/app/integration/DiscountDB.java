package com.app.integration;

/**
 * The connection to the discount DB
 */
public class DiscountDB {
    
    /**
     * Creates a new connection to a imaginary discount DB.
     * Does nothing.
     */
    public DiscountDB(){
		
	}

    /**
     * Simulates fetching discounts from the discount database.
     * It has hardcoded values rght now.
     * 
     * @param type which type of discount. (1 for items, 2 for total price, 3 for customer)
     * @param saleDTO  the sale DTO containting the information to be sent.
     * @return a double representing either the amount to be deducted from the total price of the percentage
     */
    public double discountDBQuery(int type, SaleDTO saleDTO) {
		if (type == 1) {            // Item discount total
            return 5.55;    
        } else if (type == 2) {     // Price discount percentage
            return 0.05; 
        } else if (type == 3) {     // Customer discount percentage
            return 0.1;    
        } else {                    // Invalid discount type
            return 0.0;
        }
	}
}