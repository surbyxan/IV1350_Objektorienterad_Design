package com.app.view;

import java.lang.Exception;

/**
 * Thrown when an invalid item identifier is used
 */
public class InvalidItemException extends Exception {

    private final int itemID;
    
    /**
     * Creates an error message with the invalid itemID. 
     * 
     * @param itemID the invalid itemID that was entered in view.
     */
    public InvalidItemException(int itemID) {
        super("Invalid item identifier: " + itemID + ".");
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
