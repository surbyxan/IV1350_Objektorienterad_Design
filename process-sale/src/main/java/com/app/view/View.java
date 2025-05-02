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

	private int itemID = 2;

	/**
	 * Simulates scanning an item by its ID.
	 * Calls the controller to process the item and adds it to the sale.
	 *
	 * @param itemID The ID of the item to be scanned.
	 */
	public void viewScanItem(int itemID) {
		ItemInSaleDTO showItemInSale = contr.enterItem(itemID);
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
	 */
	public void viewCalls() {
		contr.startSale(22,1305);
		System.out.println("Add 1 item with ID 10:");
		System.out.println("Item ID: 10");
		System.out.println("Item description: Cheese");
		System.out.println("Item Price: 28.00 ");
		System.out.println("VAT: 12%");
		System.out.println("Total Price: 31.36");
		ItemInSaleDTO itemInSaleDTO1 = contr.enterItem(10);
		System.out.println(itemInSaleDTO1.getString());


		System.out.println("Add 1 item with ID 10:");
		System.out.println("Item ID: 10");
		System.out.println("Item description: Cheese");
		System.out.println("Item Price: 28.00 ");
		System.out.println("VAT: 12%");
		System.out.println("Total Price: 62.72");
		ItemInSaleDTO itemInSaleDTO3 = contr.enterItem(10);
		System.out.println(itemInSaleDTO3.getString());

		System.out.println("Discounts: -5.55 SEK, 5%, and 10%");
		SaleDTO saleDTO = contr.requestDiscount();
		System.out.println(saleDTO.getString());

		contr.startPayment(this);

		contr.endSale();
	}
}
