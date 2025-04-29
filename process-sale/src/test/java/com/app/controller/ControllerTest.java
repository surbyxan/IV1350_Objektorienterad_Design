package com.app.controller;

import com.app.integration.*;
import com.app.view.View;
import com.app.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {
    
    private Controller controller;
    private Integration integration;
    private View view;

    @BeforeEach
    void setup() {
        controller = new Controller(integration);
        integration = new Integration();
        view = new View(controller);
    }
	 @AfterEach
    public void tearDown() {
        integration = null;
        controller = null;
        view = null;
    }

    @Test
    void testStartSaleAndEnterItemValid() {
        controller.startSale(1, 101);
        ItemInSaleDTO result = controller.enterItem(10);
        assertNotNull(result);
        assertEquals(10, result.getItemDTO().getID());
    }

    @Test
    void testEnterItemInvalidItemReturnsNull() {
        controller.startSale(1, 101);
        ItemInSaleDTO result = controller.enterItem(99); // 99 is invalid
        assertNull(result);
    }

    @Test
    void testEnterItemAlreadyInSale() {
        controller.startSale(1, 101);
        controller.enterItem(10);
        ItemInSaleDTO result = controller.enterItem(10); // Entering again
        assertEquals(10, result.getItemDTO().getID());
        assertEquals(2, result.getCount()); // Simplified logic, assumes same quantity
    }

    @Test
    void testRequestDiscountAppliesDiscount() {
        controller.startSale(1, 101);
        controller.enterItem(10);
        SaleDTO saleDTO = controller.requestDiscount();
        assertEquals(22.067549999999997, saleDTO.getRunningTotal(), 0.01); // 10% discount
    }

    // todo if redirect sys.out is relevant
    // @Test
    // void testStartPaymentAndReceipt() {
    //     controller.startSale(1, 101);
    //     controller.enterItem(10);
    //     controller.startPayment(view);

    //     assertEquals(view.wasPaymentSent());
    //     // assertTrue(integration.wasReceiptPrinted());
    // }

    // @Test
    // void testEndSaleSendsInfo()
}