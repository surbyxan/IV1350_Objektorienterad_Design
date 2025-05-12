package com.app.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemNotFoundExceptionTest {
    @Test 
    void testItemNotFoundErrorMessage() {
        int testItemID = 100;

        ItemNotFoundException exception = new ItemNotFoundException(testItemID);

        String expectedString =  "Unable to find Database entry for item ID: 100.";
        assertEquals(expectedString, exception.getMessage());
    }
}