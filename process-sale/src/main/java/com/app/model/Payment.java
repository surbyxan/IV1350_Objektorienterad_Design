package com.app.model;

public class Payment {

	private double totalPrice;
	private double amountPaid;
	private double changeBack;

	public Payment(double totalPrice) {
		this.totalPrice = totalPrice;
		this.amountPaid = 0;
		this.changeBack = 0;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setAmountPaid(double amountPaid) {
		amountPaid = amountPaid;
	}

	public void setChangeBack(double changeBack) {
		changeBack = changeBack;
	}
}