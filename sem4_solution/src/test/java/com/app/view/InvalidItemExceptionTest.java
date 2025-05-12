package test.java.com.app.view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InvalidItemExceptionTest {
    @Test 
    void testInvalidItemErrorMessage() {
        int testItemID = 100;

        InvalidItemException exception = new InvalidItemException(testItemID);

        String expectedString =  "Invalid item identifier: 100.";
        assertEquals(expectedMessage, exception.getMessage());
    }
}