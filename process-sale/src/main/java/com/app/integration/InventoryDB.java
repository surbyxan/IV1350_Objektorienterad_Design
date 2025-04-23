package com.app.integration;

import java.util.HashMap;
import java.lang.Integer;

/**
 * The connection to a inventory DB
 */
public class InventoryDB {

    private HashMap<Integer, ItemDTO> items;
    
    /**
     * Simulates creating a new connection to a imaginary inventory DB
     * by creating a hashmap that contains ItemDTOs.
     */
    public InventoryDB() {
        this.items = new HashMap<Integer, ItemDTO>(); 
        
        // ItemDTO(itemID, itemName, itemPrice, itemVAT)
        items.put(1, new ItemDTO(1, "Cucumber", 14.90, 1.788)); 	  // 12 % VAT
        items.put(2, new ItemDTO(2, "Whole Milk", 11.50, 1.38));      // 12% VAT
        items.put(3, new ItemDTO(3, "Toothpaste", 29.90, 5.98));      // 25% VAT
        items.put(4, new ItemDTO(4, "Pasta", 22.00, 2.64));           // 12% VAT
        items.put(5, new ItemDTO(5, "Notebook", 35.00, 8.75));        // 25% VAT
        items.put(6, new ItemDTO(6, "Apple", 6.90, 0.414));           // 6% VAT
        items.put(7, new ItemDTO(7, "Dish Soap", 24.90, 4.98));       // 25% VAT
        items.put(8, new ItemDTO(8, "Carrots", 9.50, 0.57));          // 6% VAT
        items.put(9, new ItemDTO(9, "Shampoo", 49.00, 9.80));         // 25% VAT
        items.put(10, new ItemDTO(10, "Cheese", 28.00, 3.36));        // 12% VAT
        items.put(11, new ItemDTO(11, "Ground Coffee", 42.00, 5.04)); // 12% VAT
        items.put(12, new ItemDTO(12, "Bread", 25.00, 1.50));         // 6% VAT
        items.put(13, new ItemDTO(13, "Yogurt", 10.00, 1.20));        // 12% VAT
        items.put(14, new ItemDTO(14, "Chocolate Bar", 15.00, 3.00)); // 25% VAT
        items.put(15, new ItemDTO(15, "Lettuce", 12.00, 0.72));       // 6% VAT
        items.put(16, new ItemDTO(16, "Laundry Detergent", 79.90, 15.98)); // 25% VAT

	}

    /**
     * The method that checks if an itemID is valid.
     */
    public boolean signalValidItem( int itemID ) {
        return items.containsKey(itemID);
    }

    /**
     * The method that returns the corresponding ItemDTO for an itemID.
     */
    public ItemDTO getItemData( int itemID ) {
        return items.get(itemID);
    }

    /**
     * Simulates updating external inventory system by doing nothing.
     */
    private void updateDB( SaleDTO saleDTO ) {
        int hej = 1;
        // do update
    }
}