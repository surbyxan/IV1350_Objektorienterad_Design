package com.app.model;

import com.app.integration.*;
import java.io.*;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The receipt of a Sale and Payment.
 */
public class Receipt {

	private Payment pay;
	private SaleDTO saleDTO;
	private StringBuilder receiptString;

	/**
	 * Creates a new receipt and formats the contents pay and saleDTO
	 * to a StringBuilder.
	 * 
	 * @param pay The payment record to be used.
	 * @param saleDTO The sale record to be used.
	 */
	public Receipt(Payment pay, SaleDTO saleDTO) {
		this.pay = pay;
		this.saleDTO = saleDTO; 
		receiptString = new StringBuilder();

		addHeader();

		// Iterate over each ItemInSale in saleDTO
		for (ItemInSale item : saleDTO.getItemsInSale().values()) {
			addItemToReceipt(item);
		}

		addFooter();
	}

	/**
	 * Getter for the receipt formatted to a string.
	 * 
	 * @return the receipt as a string.
	 */
	public String getString(){
		return receiptString.toString();
	}

	private void addHeader() {
		LocalDateTime dateTime = saleDTO.getTimeOfSale();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Define the format

		receiptString.append("---------- Begin receipt ----------\n");
		receiptString.append("Time of Sale: " + dateTime.format(formatter) + "\n\n");
	}

	private void addItemToReceipt(ItemInSale item) {
		String description = item.getItem().getDescription();
		int count = item.getCount();
		double price = item.getItem().getPrice() + item.getItem().getVATPrice();
		double itemTotalPrice = count * price; 

		receiptString.append(description + "        " + count + " X " + price + "    " + itemTotalPrice + " SEK\n");

	}

	private void addFooter() {
		receiptString.append(saleDTO.getTotalWithAndWithoutDiscountAsString());
		
		double total = saleDTO.getRunningTotal();
		double vat = saleDTO.getRunningVAT();
		receiptString.append("\nTotal:" + "                " + total + "\n");
		receiptString.append("VAT:  " + vat + "\n\n");

		double paid = pay.getAmountPaid();
		double change = pay.getChangeBack();
		receiptString.append("Cash:" + "                " + paid + "SEK\n");
		receiptString.append("Change:" +  "             " + change + "SEK\n");
		receiptString.append("---------- End receipt ----------\n");
	}
	
}