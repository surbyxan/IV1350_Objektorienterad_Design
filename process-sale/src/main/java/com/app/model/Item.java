package com.app.model;
import com.app.integration.*;
/**
     * The method that creates items that represents different items in the sale. Is created on "addItem"
     */
public class Item {

	public int itemID;
	private String itemDescription;
	private double itemPrice;
	private double itemVATPrice;

	public Item( ItemDTO item ) {
		this.itemID = item.getID();
		this.itemDescription = item.getDescription();
		this.itemPrice = item.getPrice();
		this.itemVATPrice = item.getVATPrice();
	}

	public int getID(){
		return this.itemID;
	}

	public String getDescription(){
		return this.itemDescription;
	}

	public double getPrice(){
		return this.itemPrice;
	}

	public double getVATPrice() {
		return this.itemVATPrice;
	}
}
