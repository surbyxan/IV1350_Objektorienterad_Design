package com.app.integration;

/**
 * The connection to the accounting DB
 */
public class AccountingDB {
    
    /**
     * Creates a new connection to a imaginary accounting DB.
     * Does nothing.
     */
    public AccountingDB() {
		
	}

    /**
     * Updates the information to our imaginary accounting system.
     * 
     * @param saleDTO the sale DTO containting the information to be sent.
     */
    public void updateDB( SaleDTO saleDTO) {
        System.out.println("Information of the sale has been sent to the external accounting system");
    }
}
