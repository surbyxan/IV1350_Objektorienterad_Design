package main.java.com.app.integration;

import java.lang.Exception;

/**
 * Thrown when InventoryDB can not find an ItemDTO for an item id.
 */
public class ItemNotFoundException extends Exception {

    private final int itemID;
    
    /**
     * Creates an error message with the itemID that could not be found
     * and passes it to the super class Exception.
     * 
     * @param itemID the id for an item that could not be found
     */
    public ItemNotFoundException(int itemID) {
        super("Unable to find Database entry for item ID: " + itemID + ".");
        this.itemID = itemID;
    }

    /**
     * Getter for the item id related to the exception.
     * 
     * @return the itemID responsible for the exception.
     */
    public int getItemID() {
        return this.itemID;
    }

}