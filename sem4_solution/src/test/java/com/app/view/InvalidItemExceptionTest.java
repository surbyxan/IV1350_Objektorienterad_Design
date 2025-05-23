package com.app.view;

import org.junit.jupiter.api.Test;

import com.app.view.InvalidItemException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.app.controller.*;
import com.app.integration.*;
import com.app.model.*;


public class InvalidItemExceptionTest {
    private Integration intgr;
    private Controller contr;
    
    @BeforeEach
    void setup(){
        this.intgr = new Integration();
        this.contr = new Controller(intgr);
                
        this.contr.startSale(1, 1);
    }
    
    @AfterEach
    public void tearDown() {
        intgr = null;
        contr = null;
    }
    

    @Test 
    void testInvalidItemErrorMessage() {
        int testItemID = 100;
        try {
            contr.enterItem(testItemID);
            fail("Exception was not thrown");
        } catch (InvalidItemException e) {
            String expectedString =  "This item ID is invalid: 100.\n\n";
            assertEquals(expectedString, e.getMessage());
        }
        
    }

    @Test 
    void testValidItemDoesNotTriggerException() {
        int validItemID = 5;
        
        try {
            ItemInSaleDTO item = contr.enterItem(validItemID);
            assertNotNull(item);
        } catch (InvalidItemException e) {
            fail("Exception was thrown");           
        }
    }


}