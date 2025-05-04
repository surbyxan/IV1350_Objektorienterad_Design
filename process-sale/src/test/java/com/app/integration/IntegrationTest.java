package com.app.integration;

import com.app.integration.*;
import com.app.view.View;
import com.app.model.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class IntegrationTest {
     
    private Integration integration;
    private InventoryDB inv;
    private AccountingDB acc;
    private DiscountDB dis;
    private Printer prt;

    @BeforeEach
    void setup() {
        integration = new Integration();
        inv = new InventoryDB();
        acc = new AccountingDB();
        dis = new DiscountDB();
        prt = new Printer();
    }

	@AfterEach
    public void tearDown() {
        integration = null;
        inv = null;
        acc = null;
        dis = null;
        prt = null;
    }


    @Test
    void testSignalValidItem() {
        assertTrue(integration.signalValidItem(10));
        assertFalse(integration.signalValidItem(999));
    }

    @Test
    void testFetchItemDataReturnsCorrectItem() {
        ItemDTO item = integration.fetchItemData(10);
        assertNotNull(item);
        assertEquals("Cheese", item.getDescription());
    }

    @Test
    void testFetchDiscountReturnsCorrectValues() {
        SaleDTO saleDTO = new SaleDTO(new Sale(2, 6));
        DiscountCollectionDTO discount = integration.fetchDiscount(saleDTO);
        assertEquals(5.55, discount.getItemDiscount(), 0.01);
        assertEquals(0.05, discount.getPriceDiscountPercentage(), 0.01);
        assertEquals(0.10, discount.getCustomerDiscountPercentage(), 0.01);
    }


    @Test
    void testSendSaleInfoDoesNotCrash() {
        SaleDTO saleDTO = new SaleDTO(new Sale(2, 6));
        
        assertDoesNotThrow(() -> integration.sendSaleInfo(saleDTO));
    }
    
}