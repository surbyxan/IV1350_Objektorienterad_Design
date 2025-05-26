package com.app.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.app.controller.*;
import com.app.integration.*;
import com.app.model.*;
import com.app.view.View;

public class ViewCallsTest {
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
    void correctItemDescriptionCheese() {

        view.viewCalls();

        String printout = printoutBuffer.toString();
        String expectedOutput = "Item description: Cheese";
        assertTrue(printout.contains(expectedOutput), "View Calls does not display item description for cheese.");
    }

    @Test 
    void correctInventoryItemErrorMessage() {

        view.viewCalls();

        String printout = printoutBuffer.toString();
        String expectedOutput = "Something went wrong when trying to fetch item ID: 17. The provided id is invalid.";
        assertTrue(printout.contains(expectedOutput), "The incorrect message was displayed on inventory item error.");
    }

    @Test 
    void correctDiscountMessage() {

        view.viewCalls();
        view.viewCalls2();

        String printout = printoutBuffer.toString();
        String expectedValues = "Discounts: -5.55 SEK, 5%, and 10%";
        assertTrue(printout.contains(expectedValues), "Incorrect discount values was displayed.");
    }

    @Test 
    void correctRevenueMessage() {

        view.viewCalls();
        view.viewCalls2();

        String printout = printoutBuffer.toString();
        String expectedOutputPreviousRevenue = "The previous total revenue was:      48.88035 SEK";
        String expectedOutputThisSale = "The revenue from the latest sale is: 28.78785 SEK";
        String expectedOutputNewRevenue = "The new total revenue is:            77.6682 SEK";
        
        assertTrue(printout.contains(expectedOutputPreviousRevenue), "Incorrect previous revenue was displayed.");
        assertTrue(printout.contains(expectedOutputThisSale), "Incorrect total sale amount was displayed.");
        assertTrue(printout.contains(expectedOutputNewRevenue), "Incorrect new revenue was displayed.");
    }

    @Test 
    void correctExternalAccountingSystemTransmissionMessage() {

        view.viewCalls();

        String printout = printoutBuffer.toString();
        String expectedOutput = "Information of the sale has been sent to the external accounting system";
        assertTrue(printout.contains(expectedOutput), "Incorrect message when sending information to external accounting system was displayed.");
    }

    @Test 
    void correctExternalInventorySystemTransmissionMessage() {

        view.viewCalls();

        String printout = printoutBuffer.toString();
        String expectedOutput = "Information of the sale has been sent to the external inventory system";
        assertTrue(printout.contains(expectedOutput), "Incorrect message when sending information to external inventory system was displayed.");
    }

    @Test 
    void correctAmountToBePaid() {

        view.viewCalls();
       
        String printout = printoutBuffer.toString();
        String expectedOutput = "Amount to pay: 48.88035";
        assertTrue(printout.contains(expectedOutput), "Incorrect new total after applied discounts was displayed.");
    }
}