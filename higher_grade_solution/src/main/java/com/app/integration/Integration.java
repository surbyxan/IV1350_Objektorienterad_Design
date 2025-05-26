package com.app.integration;

import com.app.model.Receipt;
import java.lang.RuntimeException;
/**
 * The integration class that handles connection to the external systems and the
 * printer.
 */
public class Integration {

    private InventoryDB inv;
    private AccountingDB acc;
    private DiscountDB dis;
    private Printer prt;

    /**
     * Creates objects that represents connections to the external systems and the
     * printer
     */
    public Integration() {
        this.inv = new InventoryDB();
        this.acc = new AccountingDB();
        this.dis = new DiscountDB();
        this.prt = new Printer();
    }

   
    /**
     * Fetches information from the external inventory system about an item using its ID.
     * 
     * @param itemID the ID of the item whose information is fethced
     * @throws InventoryDatabaseException if the database connection could not be established (handles Task 1 b)
     * @throws ItemNotFoundException if the itemID could not be found in the inventoryDB
     * @return an item DTO containing information about the item
     */
    public ItemDTO fetchItemData(int itemID) throws InventoryDatabaseException, 
                                                    ItemNotFoundException {
        if (itemID == 8)
            throw new InventoryDatabaseException(itemID, "Connection to inventory database could not be established.");
        return inv.getItemData(itemID);
    }

    /**
     * Fetches the three different types of discounts from the discount database
     * 
     * @param saleDTO the sale for which the discounts should be applied to
     * @return a discount collction DTO containing all of the discounts for the sale
     */
    public DiscountCollectionDTO fetchDiscount(SaleDTO saleDTO) {

        double itemDiscount = dis.discountDBQuery(1, saleDTO);
        double priceDiscountPercentage = dis.discountDBQuery(2, saleDTO);
        double customerDiscountPercentage = dis.discountDBQuery(3, saleDTO);

        return new DiscountCollectionDTO(itemDiscount, priceDiscountPercentage, customerDiscountPercentage);
    }

    /**
     * Prints the receipt from the printer
     * 
     * @param receipt the receipt to be printed
     */
    public void printFakeReceipt(Receipt receipt) {
        // prt.printFakeReceipt(receipt);
    }

    /**
     * Send information from the sale to the external accounting and inventory systems.
     * 
     * @param saleDTO the sale DTO containing the information to be sent
     */
    public void sendSaleInfo(SaleDTO saleDTO) {
        acc.updateDB(saleDTO);
        inv.updateDB(saleDTO);
    }
}
