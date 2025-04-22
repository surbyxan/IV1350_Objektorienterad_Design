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
    public Integration(InventoryDB inv, AccountingDB acc, DiscountDB dis, Printer prt ) {
        this.inv = new InventoryDB();
        this.acc = new AccountingDB();
        this.dis = new DiscountDB();
        this.prt = new Printer();

    }
    
    public boolean signalValidItem(int itemID){
       
        return inv.signalValidItem(itemID);
    }

    public ItemDTO fetchItemData(int itemID){

        return inv.getItemData(itemID);
    }
}

