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
	 * Simulates scanning an item by its ID.
	 * Calls the controller to process the item and adds it to the sale.
	 *
	 * @param itemID The ID of the item to be scanned.
	 */
	public void viewScanItem(int itemID) {
		ItemInSaleDTO showItemInSale = contr.enterItem(itemID);
	}

	

	/**
	 * Calls the application for a sample run of the program
	 */
	public void viewCalls() {
		contr.startSale(22,1305);

		ItemInSaleDTO itemInSaleDTO1 = contr.enterItem(10);
		System.out.println("Add 1 item with ID 10:");
		System.out.println("Item ID: 10");
		System.out.println("Item description: " + itemInSaleDTO1.getString());
		System.out.println("Item Price: 28.00 ");
		System.out.println("VAT: 12%");
		System.out.println("Total Price: 31.36");
		System.out.println();

		ItemInSaleDTO itemInSaleDTO3 = contr.enterItem(10);
		System.out.println("Add 1 item with ID 10:");
		System.out.println("Item ID: 10");
		System.out.println("Item description: " + itemInSaleDTO1.getString());
		System.out.println("Item Price: 28.00 ");
		System.out.println("VAT: 12%");
		System.out.println("Total Price: 62.72");
		System.out.println();

		System.out.println("Discounts: -5.55 SEK, 5%, and 10%");
		SaleDTO saleDTO = contr.requestDiscount();

		// Payment Diagram
		double totalPrice = contr.startPayment();
		System.out.println("The price to pay is: "+ totalPrice); 

		double changeBack = contr.setAmountPaid(totalPrice);
		System.out.println("Give change: "+ changeBack); 

		// createReceipt Diagram
		Receipt receipt = contr.createReceipt();
		
		printReceipt(receipt);

		contr.endSale();
	}

	private StringBuilder receiptString;

	private void printReceipt(Receipt receipt){
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
