package com.app.model;

public class Payment {

	private double totalPrice;
	private double amountPaid;
	private double changeBack;

	public Payment(double totalPrice, double amountPaid, double changeBack) {
		this.totalPrice = totalPrice;
		this.amountPaid = amountPaid;
		this.changeBack = changeBack;
	}

}