package com.app.integration;

import com.app.model.*;
/**
 * The printer class that prints the receipt
 */
public class Printer {
	private StringBuilder receiptString;
    private Receipt receipt;
    
    /**
     * Creates a new printer.
     * Does nothing.
     */
    public Printer() {}

    private void fakeReceipt(Receipt receipt){
		receiptString = new StringBuilder();
        this.receipt = receipt;

		addHeader();
		// Iterate over each ItemInSale in saleDTO
		for (ItemInSale item : receipt.getSaleDTO().getItemsInSale().values()) {
			addItemToReceipt(item);
		}
		addFooter();

    }
    /**
     * The method used to print the receipt
     * 
     * @param receipt the receipt to be printed
     */
    public void printFakeReceipt(  ) {
        
        System.out.println( "this is a fake receipt" );
    }

	private void addHeader() {
		
		receiptString.append("---------- Begin receipt ----------\n");
		receiptString.append("Time of Sale: " + receipt.getDateTime().format(receipt.getFormatter()) + "\n\n");
	}

	private void addItemToReceipt(ItemInSale item) {
		String description = item.getItem().getDescription();
		int count = item.getCount();
		double price = item.getItem().getPrice() + item.getItem().getVATPrice();
		double itemTotalPrice = count * price; 

		receiptString.append(description+ "        " + count + " X " + price + "    " + itemTotalPrice + " SEK\n");

	}

	private void addFooter() {
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