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
	private LocalDateTime dateTime;
	private DateTimeFormatter formatter;
	private double total;
	private double vat;
	private double paid;
	private double change;

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
		this.dateTime = saleDTO.getTimeOfSale();
		this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Define the format
		total = saleDTO.getRunningTotal();
		vat = saleDTO.getRunningVAT();
		paid = pay.getAmountPaid();
		change = pay.getChangeBack();
	}

	/**
	 * Getter for the payment associated with the transaction.
	 *
	 * @return The payment object.
	 */
	public Payment getPayment() {
		return pay;
	}

	/**
	 * Getter for the SaleDTO containing information about the sale.
	 *
	 * @return The SaleDTO object.
	 */
	public SaleDTO getSaleDTO() {
		return saleDTO;
	}

	/**
	 * Getter for the date and time when the transaction occurred.
	 *
	 * @return The date and time as a LocalDateTime object.
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Getter for the formatter used to format date and time values.
	 *
	 * @return The DateTimeFormatter object.
	 */
	public DateTimeFormatter getFormatter() {
		return formatter;
	}

	/**
	 * Getter for the total amount of the sale.
	 *
	 * @return The total amount.
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Getter for the VAT (Value Added Tax) for the sale.
	 *
	 * @return The VAT amount.
	 */
	public double getVAT() {
		return vat;
	}

	/**
	 * Getter for the amount paid by the customer.
	 *
	 * @return The amount paid.
	 */
	public double getPaid() {
		return paid;
	}

	/**
	 * Getter for the change to be given back to the customer.
	 *
	 * @return The change amount.
	 */
	public double getChange() {
		return change;
	}

	
}