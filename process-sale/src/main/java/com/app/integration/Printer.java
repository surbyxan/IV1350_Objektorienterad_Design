package com.app.integration;

/**
 * The printer class that prints the receipt
 */
public class Printer {
    
    /**
     * Creates a new printer.
     * Does nothing.
     */
    public Printer(){
		
	}

    /**
     * The method used to print the receipt
     * 
     * @param receipt the receipt to be printed
     */
    public printReceipt( Receipt receipt ) {
        System.out.println( "Hello printer!" );
    }
}