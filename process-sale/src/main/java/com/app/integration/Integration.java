package com.app.integration;

/**
 * The integration class that handles connection to the DB's and the printer
 */
public class Integration {

    private InventoryDB inv;
    private AccountingDB acc;
    private DiscountDB dis;
    private Printer prt;

    /**
     * The method that creates objects that represents connections to the DB's and the printer
     */
    public Integration() {
        this.inv = new InventoryDB();
        this.acc = new AccountingDB();
        this.dis = new DiscountDB();
        this.prt = new Printer();

    }
    
}

