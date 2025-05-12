package com.app.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import com.app.controller.*;
import com.app.model.*;
import com.app.view.InvalidItemException;

public class ItemNotFoundExceptionTest {
    private Integration intgr;
    
    @BeforeEach
    void setup(){
        this.intgr = new Integration();
    }
    
    @AfterEach
    public void tearDown() {
        intgr = null;
    }
    

    @Test 
    void testInvalidItemErrorMessage() {
        int testItemID = 100;
        try {
            intgr.fetchItemData(testItemID);
            fail("Exception was not thrown");
        } catch (ItemNotFoundException e) {
            String expectedString =  "Unable to find Database entry for item ID: 100.";
            assertEquals(expectedString, e.getMessage());
        }
        
    }

    @Test 
    void testValidItemDoesNotTriggerException() {
        int validItemID = 5;
        try {
            ItemDTO item = intgr.fetchItemData(validItemID);
            assertNotNull(item);
        } catch (ItemNotFoundException e) {
            fail("Exception was thrown");           
        }
    }

  }