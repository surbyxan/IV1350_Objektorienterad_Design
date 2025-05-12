package main.java.com.app.integration;

import java.lang.Exception;

/**
 * Thrown when operations can not be executed because of an error 
 * regarding the inventory database
 */
public class InventoryDatabaseException extends RuntimeException {

    
    private final int itemID;
    
    /**
     * Passes the error message to super class RuntimeException.
     * 
     * @param itemID The itemID that was searched for when exception was thrown.
     * @param str The error message that describes the cause of the RuntimeException.
     */
    public InventoryDatabaseException(int itemID, String str) {
        super(str + " When trying to fetch ItemDTO for id: " + itemID + ".");
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