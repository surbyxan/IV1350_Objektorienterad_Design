// package com.app.view;

// import org.junit.jupiter.api.Test;

// import com.app.view.View;

// import static org.junit.jupiter.api.Assertions.*;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeEach;

// import com.app.controller.*;
// import com.app.integration.*;
// import com.app.model.*;

// public class ViewCallsTest {
//     private Integration intgr;
//     private Controller contr;
//     private View view;
//     private ByteArrayOutputStream printoutBuffer;
//     private PrintStream originalSysOut;
    
    
//     @BeforeEach
//     void setup(){
//         this.intgr = new Integration();
//         this.contr = new Controller(intgr);
//         this.view = new View(contr);

//         printoutBuffer = new ByteArrayOutputStream();
//         PrintStream inMemSysOut = new PrintStream(printoutBuffer);
//         originalSysOut = System.out;
//         System.setOut(inMemSysOut);

//         this.contr.startSale(1, 1);
//     }
    
//     @AfterEach
//     public void tearDown() {
//         intgr = null;
//         contr = null;
//     }
    
// // // TODO
// //     @Test 
// //     void correctItemDescription() {

// //         int testItemID = 10;
// //         contr.enterItem(testItemID);

// //         String printout = printoutBuffer.toString();
// //         String expectedOutput = "Cheese";
// //         assertTrue(printout.contains(expectedOutput), "View Calls does not display item description.");

// //     }
// }