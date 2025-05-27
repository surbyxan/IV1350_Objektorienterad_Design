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

    private final int cashierID;
    private final int customerID;
    private final int saleID;
	private final LocalDateTime timeOfSale;
	private final double runningVAT;
	private final double runningItemPrice;
	private final double runningTotal;
	private final double runningItemCount;
    private final double availableChange;
	private final double totBeforeDiscount;
	private final double totAppliedDiscount;

	private final DiscountCollectionDTO discount;

	private final HashMap<Integer, ItemInSale> items;

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
        
        this.runningVAT = sale.getRunningVAT();
        this.runningItemPrice = sale.getRunningItemPrice();
        this.runningTotal = sale.getRunningTotal();
        this.runningItemCount = sale.getRunningItemCount();

        this.availableChange = sale.getAvailableChange();

		this.items = new HashMap<Integer, ItemInSale>();
		for (HashMap.Entry<Integer, ItemInSale> entry : sale.getItems().entrySet()) {
			Integer id = entry.getKey();
			ItemInSale itemInSale = entry.getValue();

			this.items.put(new Integer(id), new ItemInSale(itemInSale));

		}

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
	 * Getter for item count.
	 * @return The number of items in the sale.
	 */
	public double getRunningItemCount() {
		return runningItemCount;
	}

	/**
	 * Getter for available change in the register.
	 * @return The available change.
	 */
	public double getAvailableChange() {
		return availableChange;
	}

	/**
	 * Getter for the running total before discount is applied.
	 * @return running total before discount.
	 */
	public double getTotBeforeDiscount() {
		return totBeforeDiscount;
	}
	
	/**
	 * Getter for the total discount amount.
	 * @return The discounted amount.
	 */
	public double getTotAppliedDiscount() {
		return totAppliedDiscount;
	}

	/**
	 * Getter for the total discount collectionDTO.
	 * @return The discount as a DiscountCollectionDTO.
	 */
	public DiscountCollectionDTO getDiscount() {
		return discount;
	}

	/**
	 * Getter for the items in the sale.
	 * @return A map of item IDs to their corresponding ItemInSale objects.
	 */
	public HashMap<Integer, ItemInSale> getItems() {
		return items;
	}
	
	
}
