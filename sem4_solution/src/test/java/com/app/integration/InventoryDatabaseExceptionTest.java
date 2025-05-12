package com.app.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InventoryDatabaseExceptionTest {

    @Test
    void testExceptionMessageFormatting() {
        int testItemID = 17;
        String causeMessage =  "Connection to inventory database could not be established.";
        InventoryDatabaseException exception = new InventoryDatabaseException(testItemID, causeMessage);

        String expectedString = "Connection to inventory database could not be established. When trying to fetch ItemDTO for id: 17.";
        assertEquals(expectedString, exception.getMessage());
    }
}