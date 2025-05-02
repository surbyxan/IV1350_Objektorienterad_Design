package com.app.model;

import java.util.Random;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.lang.Integer;
import com.app.integration.*;

/**
 * Represents a sale transaction in the system, tracking items, discounts,
 * payment, and associated metadata like cashier and customer.
 */
public class Sale {

	private Random rnd = new Random();

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
	 * Constructs a new Sale with the specified cashier and customer IDs.
	 *
	 * @param cashierID  The ID of the cashier processing the sale.
	 * @param customerID The ID of the customer making the purchase.
	 */
	public Sale(int cashierID, int customerID) {
		this.cashierID = cashierID;
		this.customerID = customerID;

		this.saleID = rnd.nextInt(100);
		this.timeOfSale = LocalDateTime.now();
		// System.out.println(this.timeOfSale);

		this.runningVAT = 0;
		this.runningItemPrice = 0;
		this.runningTotal = 0;
		this.runningItemCount = 0;

		this.availableChange = getChange();

		this.discount = new DiscountCollectionDTO(0, 0, 0);
		this.items = new HashMap<>();
	}

	private static double getChange() {
		double change = 100;
		return change;
	}

	/**
	 * Checks if an item with the given ID is already in the sale.
	 * If found, it increases the quantity and returns the corresponding DTO.
	 *
	 * @param itemID The ID of the item to check.
	 * @return The DTO of the item in sale, or null if the item is not present.
	 */
	public ItemInSaleDTO isItemInSale(int itemID) {
		boolean itemInSale = items.containsKey(itemID);
		if (itemInSale) {
			ItemInSale item = items.get(itemID);
			increaseQuantity(itemID);
			addItemToRunningCost(item.getItem());
			return item.getItemInSaleDTO();
		} else {
			return null;
		}
	}

	private void increaseQuantity(int itemID) {
		items.get(itemID).increaseCount();
	}

	/**
	 * Adds a new item to the sale based on its DTO, and updates the totals.
	 * @param itemDTO The DTO representing the item to be added.
	 */
	public void addItem(ItemDTO itemDTO) {
		Item item = new Item(itemDTO);
		items.put(item.getID(), new ItemInSale(item));
		addItemToRunningCost(item);
	}

	private void addItemToRunningCost(Item itemToBeAdded) {
		runningItemPrice += itemToBeAdded.getPrice();
		runningVAT += itemToBeAdded.getVATPrice();
		runningTotal = runningItemPrice + runningVAT;
		runningItemCount++;
	}

	/**
	 * Returns a data transfer object representing the current sale.
	 * @return The DTO of the current sale.
	 */
	public SaleDTO getDTO() {
		return new SaleDTO(this);
	}

	/**
	 * Applies discounts from the provided collection DTO to the current sale total.
	 * @param discountCollectionDTO The DTO containing all applicable discounts.
	 */
	public void applyDiscount(DiscountCollectionDTO discountCollectionDTO) {
		discount = discountCollectionDTO;
		totBeforeDiscount = runningTotal;

		runningTotal = runningTotal - discountCollectionDTO.getItemDiscount();
		runningTotal *= (1.0 - discountCollectionDTO.getPriceDiscountPercentage());
		runningTotal *= (1.0 - discountCollectionDTO.getCustomerDiscountPercentage());

		totAppliedDiscount = totBeforeDiscount - runningTotal;
	}

	/**
	 * Initializes and returns a new Payment object based on the current total.
	 * @return A Payment object containing the total amount due.
	 */
	public Payment initPayment() {
		double totalPrice = getRunningTotal();
		return new Payment(totalPrice);
	}

	/**
	 * Generates a receipt for the sale based on the given payment.
	 * @param pay The Payment made for the sale.
	 * @return A Receipt object for the transaction.
	 */
	public Receipt getReceipt(Payment pay) {
		return new Receipt(pay, this.getDTO());
	}

	/**
	 * Getter for customer ID.
	 * @return The ID of the customer.
	 */
	public int getCustomerID() {
		return customerID;
	}

	/**
	 * Getter for cashier ID.
	 * @return The ID of the cashier.
	 */
	public int getCashierID() {
		return cashierID;
	}

	/**
	 * Getter for sale ID.
	 * @return The ID of the sale.
	 */
	public int getSaleID() {
		return saleID;
	}

	/**
	 * Getter for time of sale.
	 * @return The timestamp of when the sale was created.
	 */
	public LocalDateTime getTimeOfSale() {
		return timeOfSale;
	}

	/**
	 * Getter for running VAT.
	 * @return The accumulated VAT of the sale.
	 */
	public double getRunningVAT() {
		return runningVAT;
	}

	/**
	 * Getter for item price.
	 * @return The total price of items before VAT and discounts.
	 */
	public double getRunningItemPrice() {
		return runningItemPrice;
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
