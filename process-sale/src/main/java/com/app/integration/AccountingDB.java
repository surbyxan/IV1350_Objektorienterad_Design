package com.app.integration;

/**
 * The connection to a accounting DB
 */
public class AccountingDB {
    
    /**
     * Creates a new connection to a imaginary accounting DB.
     * Does nothing.
     */
    public AccountingDB() {
		
	}

    public void updateDB( SaleDTO saleDTO) {
        System.out.println("Information of the sale has been sent to the external accounting system");
    }
}
