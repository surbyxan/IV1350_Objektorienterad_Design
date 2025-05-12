package com.app.model;

import com.app.integration.*;
import com.app.model.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ReceiptTest {

    private Receipt receipt;

    @BeforeEach
    void setup () {

	Sale sale = new Sale(11, 23);

	ItemDTO itemDTO1 = new ItemDTO(6, "Apple" , 6.90, 0.414);
	sale.addItem(itemDTO1); 
	sale.isItemInSale(6);
	ItemDTO itemDTO2 = new ItemDTO(8, "Banana" , 7.90, 0.514);
	sale.addItem(itemDTO2); 

	DiscountCollectionDTO discount = new DiscountCollectionDTO(0, 0.05, 0);

	sale.applyDiscount(discount);

	Payment payment = sale.initPayment();
	payment.setAmountPaid(35);
	payment.setChangeBack(5);
	receipt = sale.getReceipt(payment);
	//System.out.println(receipt.getString());
	
    }

    @Test
    void testReceiptContainsHeader() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("---------- Begin receipt ----------"));
	assertTrue(receiptString.contains("Time of Sale: 20"));
    }

    @Test
    void testReceiptContainsAllItems() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("Apple        2 X "));
	assertTrue(receiptString.contains("Banana        1 X "));
    }

    @Test
    void testReceiptContainsTotal() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("Total:                21"));
    }

    @Test
    void testReceiptContainsDiscount() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("Discounts:"));
	assertTrue(receiptString.contains("Total Price Discount:  5.0%"));
    }

    @Test
    void testReceiptContainsPaymentInfo() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("Cash:                35.0SEK"));
	assertTrue(receiptString.contains("Change:             5.0SEK"));
    }

    @Test
    void testReceiptContainsFooter() {
	String receiptString = receipt.getString();
	assertTrue(receiptString.contains("---------- End receipt ----------"));
    }

}
