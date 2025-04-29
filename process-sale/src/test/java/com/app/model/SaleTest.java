package com.app.model;

import java.time.LocalDateTime;
import com.app.integration.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class SaleTest {

	private Sale sale;
    private Integration integration;

	@BeforeEach
	void setup() {
		sale = new Sale(1, 101);
        integration = new Integration();
    }

	 @AfterEach
    public void tearDown() {
        integration = null;
        sale = null;
    }

	@Test
	void doesTheSaleConstructorSetSaleIDAndTimeOfSale() {
		int ID = sale.getSaleID();
		LocalDateTime time = sale.getTimeOfSale();

		assertEquals(1, sale.getCashierID());
		assertEquals(101, sale.getCustomerID());
		assertEquals(50, ID, 100);
		assertNotNull(time);
	}

	@Test
	void doesAddItemAddToTheSale() {
		ItemDTO itemDTO = new ItemDTO(6, "Apple" , 6.90, 0.414);
		sale.addItem(itemDTO);

		assertEquals(6.90, sale.getRunningItemPrice());
        assertEquals(0.414, sale.getRunningVAT());
        assertEquals(7.314, sale.getRunningTotal());
        assertEquals(1.0, sale.getRunningItemCount());
        assertTrue(sale.getItems().containsKey(6));
	}
//! frn chattis ändra discount
	@Test
    void testApplyDiscountReducesTotal() {
        ItemDTO itemDTO = new ItemDTO(6, "Apple" , 6.90, 0.414);
        sale.addItem(itemDTO);  // Total: 20 + 4 = 24

        DiscountCollectionDTO discount = new DiscountCollectionDTO(4.0, 0.10, 0.10); // 4 off, then 10% + 10% off
        sale.applyDiscount(discount);

        double expectedAfterDiscount = (24.0 - 4.0) * 0.9 * 0.9;
        assertEquals(expectedAfterDiscount, sale.getRunningTotal(), 0.001);
        assertEquals(24.0, sale.getTotBeforeDiscount());
        assertEquals(24.0 - expectedAfterDiscount, sale.getTotAppliedDiscount(), 0.001);
    }

    @Test
    void testInitPaymentReturnsCorrectAmount() {
        ItemDTO itemDTO = new ItemDTO(6, "Apple" , 6.90, 0.414);
        sale.addItem(itemDTO); // Total: 15 + 3 = 18

        Payment payment = sale.initPayment();
        assertEquals(18.0, payment.getTotalPrice());
    }

    @Test
    void testGetReceiptReturnsValidReceipt() {
        ItemDTO itemDTO = new ItemDTO(6, "Apple" , 6.90, 0.414);
        sale.addItem(itemDTO);
        Payment payment = sale.initPayment();
        Receipt receipt = sale.getReceipt(payment);

        assertNotNull(receipt);
    
    }
}