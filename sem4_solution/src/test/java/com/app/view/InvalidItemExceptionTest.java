package com.app.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidItemExceptionTest {
    @Test 
    void testInvalidItemErrorMessage() {
        int testItemID = 100;
        InvalidItemException exception = new InvalidItemException(testItemID);

        String expectedString =  "This item was not found: 100.";
        assertEquals(expectedString, exception.getMessage());
    }
}