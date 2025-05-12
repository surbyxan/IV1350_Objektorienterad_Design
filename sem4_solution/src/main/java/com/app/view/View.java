package com.app.view;
import com.app.controller.*;
import com.app.integration.*;
import com.app.model.*;

/**
 * Handles interaction with the user interface layer.
 * This class simulates the UI operations like scanning items and sending payment information.
 */
public class View {

	private Controller contr;

	/**
	 * Creates a new instance of {@code View}.
	 */
	public View(Controller contr) {
		this.contr = contr;
	}

	/**
	 * Sends payment information for processing.
	 * Displays the total price, sets the amount paid, and assumes no change is needed.
	 *
	 * @param pay The {@code Payment} object containing payment data.
	 */
	public void sendPaymentInfo(Payment pay) {
		System.out.println(pay.getTotalPrice()); 
		pay.setAmountPaid(pay.getTotalPrice());
		pay.setChangeBack(0);
	}

	/**
	 * Calls the application for a sample run of the program
	 * @throws InvalidItemException when a item ID is not found in the database
	 */
	public void viewCalls() {
		contr.startSale(22,1305);
			
		try {
			ItemInSaleDTO itemInSaleDTO1 = contr.enterItem(10);
			if (itemInSaleDTO1 != null){
				System.out.println("Add 1 item with ID 10:");
				System.out.println("Item ID: 10");
				System.out.println("Item description: " + itemInSaleDTO1.getString());
				System.out.println("Item Price: 28.00 ");
				System.out.println("VAT: 12%");
				System.out.println("Total Price: 31.36");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			System.out.println(invalidItemExc.getMessage());
		}
			
		try {
			ItemInSaleDTO itemInSaleDTO2 = contr.enterItem(10);
			if (itemInSaleDTO2 != null){
				System.out.println("Add 1 item with ID 10:");
				System.out.println("Item ID: 10");
				System.out.println("Item description: " + itemInSaleDTO2.getString());
				System.out.println("Item Price: 28.00 ");
				System.out.println("VAT: 12%");
				System.out.println("Total Price: 62.72");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			System.out.println(invalidItemExc.getMessage());
		}
			
		try {
			ItemInSaleDTO itemInSaleDTO3 = contr.enterItem(8);
			if (itemInSaleDTO3 != null){
				System.out.println("Add 1 item with ID 8:");
				System.out.println("Item ID: 8");
				System.out.println("Item description: " + itemInSaleDTO3.getString());
				System.out.println("Item Price: 9.50 ");
				System.out.println("VAT: 6%");
				System.out.println("Total Price: 72.22");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			System.out.println(invalidItemExc.getMessage());
		}
			
		try {
			ItemInSaleDTO itemInSaleDTO4 = contr.enterItem(17);
			if (itemInSaleDTO4 != null){
				System.out.println("Add 1 item with ID 17:");
				System.out.println("Item ID: 17");
				System.out.println("Item description: " + itemInSaleDTO4.getString());
				System.out.println("Item Price: 9.50 ");
				System.out.println("VAT: 6%");
				System.out.println("Total Price: 72.22");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			System.out.println(invalidItemExc.getMessage());
		}
			
		System.out.println("Discounts: -5.55 SEK, 5%, and 10%");
		SaleDTO saleDTO = contr.requestDiscount();
		System.out.println(saleDTO.getString());
		
		contr.startPayment(this);
		
		contr.endSale();
	}
}
