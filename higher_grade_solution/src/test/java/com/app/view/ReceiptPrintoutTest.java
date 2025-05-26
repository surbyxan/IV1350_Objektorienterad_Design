package com.app.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import java.time.*;
import java.time.format.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.app.controller.*;
import com.app.integration.*;
import com.app.model.*;
import com.app.view.View;

public class ReceiptPrintoutTest {
    private Integration intgr;
    private Controller contr;
    private View view;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    
    
    @BeforeEach
    void setup(){
        this.intgr = new Integration();
        this.contr = new Controller(intgr);
        this.view = new View(contr);

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);

        this.contr.startSale(1, 1);
    }
    
    @AfterEach
    public void tearDown() {
        intgr = null;
        contr = null;
        view = null;
        printoutBuffer = null;
        System.setOut(originalSysOut);
    }
    
	@Test 
    void correctTimeForReceipt() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String expectedNow = now.format(formatter);
       
		view.viewCalls();
        String printout = printoutBuffer.toString();
        assertTrue(printout.contains(expectedNow), "The receipt does not contain the right time.");

    }

    
    @Test 
    void correctLineForApple() {
        try {
            ItemInSaleDTO itemInSaleDTO1 = contr.enterItem(6);  // Add Apple to sale
            Receipt receipt = contr.startPayment(view);
            view.printReceipt(receipt);
            String printout = printoutBuffer.toString();
            // String expectedOutput = "Apples        1 X 6.90    6.90 SEK";
            String expectedOutputItem = "Apple";
            String expectedOutputQuantity = "1 X 7.314";
            String expectedOutputTotalPrice = "7.314 SEK";
            assertTrue(printout.contains(expectedOutputItem), "The receipt does not contain the correct item");
            assertTrue(printout.contains(expectedOutputQuantity), "The recepit does not contain the correct quantity of apples");
            assertTrue(printout.contains(expectedOutputTotalPrice), "The receipt does not contain the correct total price for apples");
        } catch (InvalidItemException e) {
			fail("whopsies");
        }
    }
}