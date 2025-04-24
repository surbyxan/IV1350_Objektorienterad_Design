package com.app.integration;

/**
 * The connection to a discount DB
 */
public class DiscountDB {
    
    /**
     * Creates a new connection to a imaginary discount DB.
     * Does nothing.
     */
    public DiscountDB(){
		
	}

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