package com.app.integration;

import java.util.Random;
import java.time.LocalDateTime;
// import java.util.List;
import java.util.HashMap;
import java.lang.Integer;
import com.app.model.*;
/**
 * The sale class that 
 */
public class SaleDTO {

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


	public SaleDTO(int cashierID, int customerID) {
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
		this.items = new HashMap<Integer, ItemInSale>();
	}

	private static double getChange() { 
		//checkidouble change = 100; 
        double change = 100;
		return change; // in the model it says to return an int, but it is a double
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
}