package com.app.integration;

import java.time.LocalDateTime;
// import java.util.List;
import java.util.HashMap;
import java.lang.Integer;
import com.app.model.*;

/**
 * The class represents a DTO of the active sale
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
	private double totBeforeDiscount;
	private double totAppliedDiscount;

	private DiscountCollectionDTO discount;

	private HashMap<Integer, ItemInSale> items;

	/**
	 * Creates a new {@code SaleDTO} by extracting data from the given {@code Sale} object.
	 *
	 * @param sale the  object representing the sale
	 */
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

		this.totBeforeDiscount = sale.getTotBeforeDiscount();
		this.totAppliedDiscount = sale.getTotAppliedDiscount();
		this.discount = sale.getDiscount();
	}
	
	/**
	 * Checks whether the specified item is already included in the sale and if it 
	 * item exists, its quantity in the sale is increased and its data is returned.
	 *
	 * @param itemID the identifier of the item to check
	 * @return an {@code ItemInSaleDTO} if the item is already in the sale, otherwise {@code null}
	 */
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
	
	/**
	 * Adds an item to the item list in a sale.
	 * 
	 * @param itemDTO the DTO of the item to be added
	 */
	public void addItem(ItemDTO itemDTO){
		
		Item item = new Item(itemDTO);

		items.put(new Integer(item.getID()), new ItemInSale(item));
	}

	/**
	 * Returns a mapping of item IDs to the items included in the sale.
	 *
	 * @return a {@code HashMap} containing item IDs and their corresponding {@code ItemInSale} objects
	 */
	public HashMap<Integer, ItemInSale> getItemsInSale() {
		return this.items;
	}

	/**
	 * Returns the time when the sale was initiated.
	 *
	 * @return the timestamp of the sale
	 */
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
	
	/**
	 * Getter for total sale amount but it returns a string.
	 * @return The total cost of the sale including VAT and discounts.
	 */
	public String getString() {
		return new String("Total: " + runningTotal);
	}

	
	/**
	 * Getter for total sale amount before discount is applied as a string.
	 * @return The total cost of the sale including VAT and discounts.
	 */
	public String getTotalWithAndWithoutDiscountAsString() {
		return new String("Total Before Discount:     " + totBeforeDiscount + 
						  "\n\nDiscounts:" +
						  "\n  Item Discount:       " + discount.getItemDiscount() + " SEK" +
						  "\n  Total Price Discount:  " + (discount.getPriceDiscountPercentage() *100)+ "%" +
						  "\n  Customer Discount:     " + (discount.getCustomerDiscountPercentage() *100) + "%" +
						  "\n  Total Discount:        " + totAppliedDiscount 
						  );
	}
	
}
