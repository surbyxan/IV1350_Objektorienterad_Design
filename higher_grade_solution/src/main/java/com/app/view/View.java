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
		System.out.println("Amount to pay: " + pay.getTotalPrice()); 
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
				System.out.println("Add 1 item with ID: 10");
				System.out.println("Item ID: 10");
				System.out.println("Item description: " + itemInSaleDTO1.getString());
				System.out.println("Item Price: 28.00 ");
				System.out.println("VAT: 12%");
				System.out.println("Total Price: 31.36");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			inventoryItemErrorMessage(invalidItemExc.getItemID());
			
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
			inventoryItemErrorMessage(invalidItemExc.getItemID());

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
			inventoryItemErrorMessage(invalidItemExc.getItemID());

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
			inventoryItemErrorMessage(invalidItemExc.getItemID());

		}
			
		System.out.println("Discounts: -5.55 SEK, 5%, and 10%");
		SaleDTO saleDTO = contr.requestDiscount();

		Receipt receipt = contr.startPayment(this);
		
		printReceipt(receipt);
		contr.endSale();
		System.out.println("\n----END OF SALE----\n");
	}

	/**
	 * Calls the application for a sample run of the program
	 * @throws InvalidItemException when a item ID is not found in the database
	 */
	public void viewCalls2() {
		contr.startSale(22,1302);
			
		try {
			ItemInSaleDTO itemInSaleDTO1 = contr.enterItem(12);
			if (itemInSaleDTO1 != null){
				System.out.println("Add 1 item with ID 12:");
				System.out.println("Item ID: 12");
				System.out.println("Item description: " + itemInSaleDTO1.getString());
				System.out.println("Item Price: 25.00 ");
				System.out.println("VAT: 6% ");
				System.out.println("Total Price: 26.5 ");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			// System.out.println(invalidItemExc.getMessage());
			inventoryItemErrorMessage(invalidItemExc.getItemID());
		}
			
		try {
			ItemInSaleDTO itemInSaleDTO2 = contr.enterItem(15);
			if (itemInSaleDTO2 != null){
				System.out.println("Add 1 item with ID 15:");
				System.out.println("Item ID: 15");
				System.out.println("Item description: " + itemInSaleDTO2.getString());
				System.out.println("Item Price: 12.00 ");
				System.out.println("VAT: 6%");
				System.out.println("Total Price:  12.72");
				System.out.println();
			}
		}
		catch (InvalidItemException invalidItemExc) {
			// System.out.println(invalidItemExc.getMessage());
			inventoryItemErrorMessage(invalidItemExc.getItemID());
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
			// System.out.println(invalidItemExc.getMessage());
			inventoryItemErrorMessage(invalidItemExc.getItemID());
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
			// System.out.println(invalidItemExc.getMessage());
			// System.out.println("Something went wrong when trying to fetch item ID: " + itemID +" \nPlease try again!\n");
			inventoryItemErrorMessage(invalidItemExc.getItemID());
		}
		
		System.out.println("These discounts are applied:");
		System.out.println("Discounts: -5.55 SEK, 5%, and 10%");
		SaleDTO saleDTO = contr.requestDiscount();
				
		Receipt receipt = contr.startPayment(this);
		
		printReceipt(receipt);
		
		contr.endSale();
		System.out.println("\n----END OF SALE----\n");

	}

	private void inventoryItemErrorMessage(int itemID) {
		System.out.println("Something went wrong when trying to fetch item ID: " + itemID +". The provided id is invalid.\nPlease try again!\n");
	}

	private StringBuilder receiptString;

	/**
	 * Format and print the recepeipt.
	 * 
	 * @param receipt the receipt that contains the information to be printed.
	 */
	public void printReceipt(Receipt receipt){
		receiptString = new StringBuilder();

		addHeader(receipt);
		// Iterate over each ItemInSale in saleDTO
		for (ItemInSale item : receipt.getSaleDTO().getItemsInSale().values()) {
			addItemToReceipt(receipt, item);
		}
		addFooter(receipt);

		System.out.println(receiptString.toString());

    }
   
    public void printFakeReceipt(  ) {
        
        System.out.println( "this is a fake receipt" );
    }

	private void addHeader(Receipt receipt) {
		
		receiptString.append("---------- Begin receipt ----------\n");
		receiptString.append("Time of Sale: " + receipt.getDateTime().format(receipt.getFormatter()) + "\n\n");
	}

	private void addItemToReceipt(Receipt receipt, ItemInSale item) {
		String description = item.getItem().getDescription();
		int count = item.getCount();
		double price = item.getItem().getPrice() + item.getItem().getVATPrice();
		double itemTotalPrice = count * price; 

		receiptString.append(description+ "        " + count + " X " + price + "    " + itemTotalPrice + " SEK\n");

	}

	private void addFooter(Receipt receipt) {
		receiptString.append(getTotalWithAndWithoutDiscountAsString(receipt.getSaleDTO()));
		
		
		receiptString.append("\nTotal:" + "                " + receipt.getTotal() + "\n");
		receiptString.append("VAT:  " + receipt.getVAT() + "\n\n");

		
		receiptString.append("Cash:" + "                " + receipt.getPaid() + "SEK\n");
		receiptString.append("Change:" +  "             " + receipt.getChange() + "SEK\n");
		receiptString.append("---------- End receipt ----------\n");
	}
	
	private String getTotalWithAndWithoutDiscountAsString(SaleDTO saleDTO) {
		return new String("Total Before Discount:     " + saleDTO.getTotBeforeDiscount() + 
						  "\n\nDiscounts:" +
						  "\n  Item Discount:       " + saleDTO.getDiscount().getItemDiscount() + " SEK" +
						  "\n  Total Price Discount:  " + (saleDTO.getDiscount().getPriceDiscountPercentage() *100)+ "%" +
						  "\n  Customer Discount:     " + (saleDTO.getDiscount().getCustomerDiscountPercentage() *100) + "%" +
						  "\n  Total Discount:        " + saleDTO.getTotAppliedDiscount() 
						  );
	}

}
