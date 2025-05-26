package com.app.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.*;
import java.time.format.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.app.controller.*;
import com.app.integration.*;
import com.app.model.*;
import com.app.view.View;

public class ErrorMessageHandlerTest {
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
    
// TODO
    @Test 
    void correctTimeForErrorMessage() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String expectedNow = now.format(formatter);
        view.viewCalls();

        String printout = printoutBuffer.toString();
        assertTrue(printout.contains(expectedNow), "The error message handler does not contain the right exception time.");

    }
    
    @Test 
    void correctErrorMessageForErrorMessage() {

        view.viewCalls();

        String printout = printoutBuffer.toString();
        String expectedOutput = "ERROR: Failed to get item, please try again.";
        assertTrue(printout.contains(expectedOutput), "The error message handler did not produce the right error message.");

    }
}