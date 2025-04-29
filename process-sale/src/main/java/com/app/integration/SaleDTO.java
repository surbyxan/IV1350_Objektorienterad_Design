package com.app.integration;

import java.time.LocalDateTime;
// import java.util.List;
import java.util.HashMap;
import java.lang.Integer;
import com.app.model.*;
/**
 * The sale class that 
 */
public class SaleDTO {

	
    private int cashierID;
    private int customerID;
    private int saleID;
	private LocalDateTime timeOfSale;
	private double runningVAT;
	private double runningItemPrice;
	private double runningTotal;
	private double runningItemCount;
    private double availableChange;

	private HashMap<Integer, ItemInSale> items;


	public SaleDTO(Sale sale) {
		this.cashierID = sale.getCashierID();
		this.customerID = sale.getCustomerID();

		this.saleID = sale.getSaleID();
        this.timeOfSale = sale.getTimeOfSale();
        // System.out.println(this.timeOfSale);

        this.runningVAT = sale.getRunningVAT();
        this.runningItemPrice = sale.getRunningItemPrice();
        this.runningTotal = sale.getRunningTotal();
        this.runningItemCount = sale.getRunningItemCount();

        this.availableChange = sale.getAvailableChange();
		this.items = sale.getItems();
	}

	
    public ItemInSaleDTO isItemInSale(int itemID){
		boolean itemInSale = items.containsKey(itemID);
		if (itemInSale){
			increaseQuantity(itemID);

			return items.get(itemID).getItemInSaleDTO();
			// todo get ItemDTO from itemID through Item, without calling DB
			
		}
		else {
			return null;
		}
    }

	private void increaseQuantity(int itemID){
		items.get(itemID).increaseCount();
	}
	
	public void addItem(ItemDTO itemDTO){
		
		Item item = new Item(itemDTO);

		items.put(new Integer(item.getID()), new ItemInSale(item));
	}

	public HashMap<Integer, ItemInSale> getItemsInSale() {
		return this.items;
	}

	public LocalDateTime getTimeOfSale() {
		return this.timeOfSale;
	}

	/**
	 * Getter for running VAT.
	 * @return The accumulated VAT of the sale.
	 */
	public double getRunningVAT() {
		return runningVAT;
	}

	/**
	 * Getter for total sale amount.
	 * @return The total cost of the sale including VAT and discounts.
	 */
	public double getRunningTotal() {
		return runningTotal;
	}

	
}