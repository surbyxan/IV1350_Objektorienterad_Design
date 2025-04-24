package com.app.model;

import java.util.Random;
import java.time.LocalDateTime;
// import java.util.List;
import java.util.HashMap;
import java.lang.Integer;
import com.app.integration.*;
/**
 * The sale class that 
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

	private HashMap<Integer, ItemInSale> items;


	public Sale(int cashierID, int customerID) {
		this.cashierID = cashierID;
		this.customerID = customerID;

		this.saleID = rnd.nextInt(100);
        this.timeOfSale = LocalDateTime.now();
        System.out.println(this.timeOfSale);

        this.runningVAT = 0;
        this.runningItemPrice = 0;
        this.runningTotal = 0;
        this.runningItemCount = 0;

        this.availableChange = getChange();
		this.items = new HashMap<Integer, ItemInSale>();
	}
	/** STARTUP **/
	private static double getChange() { 
		//checkidouble change = 100; 
        double change = 100;
		return change; // in the model it says to return an int, but it is a double
	}

	/** ENTER ITEM **/
    public ItemInSaleDTO isItemInSale(int itemID){
		boolean itemInSale = items.containsKey(itemID);
		if (itemInSale){
			increaseQuantity(itemID);
			return items.get(itemID).getItemInSaleDTO();
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
		
		runningItemPrice += item.getPrice();
		runningVAT += item.getVATPrice();
		runningTotal = runningItemPrice + runningVAT;
		runningItemCount++;
	}

	/** REQUEST DISCOUNT **/
	public SaleDTO getDTO() {
		return new SaleDTO(this);

	}

	public void applyDiscount(DiscountCollectionDTO discountCollectionDTO) {
		// Total price after item discount
		runningTotal = runningTotal - discountCollectionDTO.getItemDiscount();

		// Total price after price discount
		runningTotal = runningTotal * (1.0 - discountCollectionDTO.getPriceDiscountPercentage());

		// Total price after customer discount
		runningTotal = runningTotal * (1.0 - discountCollectionDTO.getCustomerDiscountPercentage());
	}


	/**PAYEMNt **/
	public Payment initPayment() {
		double totalPrice = getRunningTotal();

		return new Payment(totalPrice);
	}

	public Receipt getReceipt(Payment pay) {
		return new Receipt(pay, this.getDTO());
	}

	/** SALE GETTERS */
	public int getCustomerID() {
		return customerID;
	}

	public int getCashierID() {
		return cashierID;
	}

	public int getSaleID() {
		return saleID;
	}

	public LocalDateTime getTimeOfSale() {
		return timeOfSale;
	}

	public double getRunningVAT() {
		return runningVAT;
	}

	public double getRunningItemPrice() {
		return runningItemPrice;
	}

	public double getRunningTotal() {
		return runningTotal;
	}

	public double getRunningItemCount() {
		return runningItemCount;
	}

	public double getAvailableChange() {
		return availableChange;
	}

	public HashMap<Integer, ItemInSale> getItems() {
		return items;
	}
}