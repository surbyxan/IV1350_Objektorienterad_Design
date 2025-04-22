package com.app.model;

public class Item {

	public int itemID;
	private String itemDescription;
	private double itemPrice;
	private double itemVATPrice;

	public Item( int itemID, String itemDescription, double itemPrice, double itemVATPrice ) {
		this.itemID = itemID;
		this.itemDescriptionn = itemDescription;
		this.itemPrice = itemPrice;
		this.itemVatPrice = itemVATPrice;
	}
}