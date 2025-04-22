
package com.app.integration;

public class ItemDTO {
    public int itemID;
	private String itemDescription;
	private double itemPrice;
	private double itemVATPrice;

	public ItemDTO( int itemID, String itemDescription, double itemPrice, double itemVATPrice ) {
		this.itemID = itemID;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemVATPrice = itemVATPrice;
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