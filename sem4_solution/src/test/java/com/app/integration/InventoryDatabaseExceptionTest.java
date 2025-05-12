package com.app.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import com.app.controller.*;
import com.app.model.*;
import com.app.view.InvalidItemException;


class InventoryDatabaseExceptionTest {
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
        int testItemID = 8;
        try {
            intgr.fetchItemData(testItemID);
            fail("Exception was not thrown");
        } catch (InventoryDatabaseException e) {
            String expectedString =  "When trying to fetch ItemDTO for id: 8.";
            assertTrue(e.getMessage().contains(expectedString));
        } catch (Exception e){
            fail();
        }
        
        
    }

    @Test 
    void testValidItemDoesNotTriggerException() {
        int validItemID = 5;
        try {
            ItemDTO item = intgr.fetchItemData(validItemID);
            assertNotNull(item);
        } catch (InventoryDatabaseException e) {
            fail("Exception was thrown");           
        } catch (Exception e){
            fail();
        }
    }


}