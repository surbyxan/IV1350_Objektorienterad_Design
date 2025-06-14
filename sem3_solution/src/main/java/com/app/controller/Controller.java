package com.app.controller;

import com.app.model.*;
import com.app.integration.*;

/**
 * The class responsible for the communication between the view layer and the model layer
 */
public class Controller {

	private Sale saleInstance;
	private Integration intgr;
	private Payment ongoingPay;

	/**
	 * Constructs a new Controller with a specified integration component
	 * 
	 * @param intgr the integer component which is used
	 */
	public Controller(Integration intgr) {
		this.intgr = intgr;
	}

	/**
	 * Initializes a new sale with a specified cashier and customer.
	 *
	 * @param cashierID  the unique identifier of the cashier handling the sale
	 * @param customerID the unique identifier of the customer involved in the sale
	 */
	public void startSale(int cashierID, int customerID) {
		this.saleInstance = new Sale(cashierID, customerID);
	}

	// * ENTER ITEM
	/**
	 * Processes the entry of an item into the current sale.
	 * If the item is already part of the sale, its current sale data is returned.
	 * Otherwise, the method validates the item using the integration layer,
	 * retrieves its data, and adds it to the sale.
	 *
	 * @param itemID the unique identifier of the item to be entered into the sale
	 * @return an {@code ItemInSaleDTO} representing the item in the sale,
	 *         or {@code null} if the item's ID is invalid
	 */
	public ItemInSaleDTO enterItem(int itemID) {

		ItemInSaleDTO itemDTOWithoutDB = saleInstance.isItemInSale(itemID); // ! 1.1
		if (itemDTOWithoutDB != null) {
			return itemDTOWithoutDB;
		} else {
			if (!intgr.signalValidItem(itemID)) { // ! 1.2
				return null;
			}

			ItemDTO itemDTO = intgr.fetchItemData(itemID); // ! 1.3
			saleInstance.addItem(itemDTO); // ! 1.4

			ItemInSaleDTO itemInSaleDTO = new ItemInSaleDTO(itemDTO, 1);
			return itemInSaleDTO;
		}
	}

	// * REQUEST DISCOUNT
	/**
	 * Requests and applies discounts to the current sale by retrieving the current sale data, 
	 * fetching discounts, and applying the discounts to the sale.
	 * 
	 * @return a {@code SaleDTO} representing the updated state of the sale after applying discounts
	 */
	public SaleDTO requestDiscount() {
		SaleDTO saleDTO = saleInstance.getDTO(); 

		DiscountCollectionDTO discountData = intgr.fetchDiscount(saleDTO); 

		saleInstance.applyDiscount(discountData); 

		return saleInstance.getDTO();
	}

	/**
	 * Initiates the payment for the current sale. 
	 * 
	 * @return the totalPrice from Payment that was created from the sale.
 	 */
 	public double startPayment() {
		this.ongoingPay = saleInstance.initPayment();
		return ongoingPay.getTotalPrice();
	}

	/**
	 * Sets payment information for the view.
	 * Sets the amount paid, and returns how much change is needed.
	 *
	 * @param amountPaid The amount of money paid by the customer.
	 * 
	 * @return the amount of change to be given back.
	 */
	public double setAmountPaid(double amountPaid) {
		double changeBack = this.ongoingPay.setAmountPaid(amountPaid);

		return changeBack;
	}

	/**
	 * Creates a new receipt using the provided ongoing payment.
	 * 
	 * @return Receipt that was created to the view.
	 */
	public Receipt createReceipt(){
		Receipt receipt = saleInstance.getReceipt(this.ongoingPay);

		intgr.printFakeReceipt(receipt);

		return receipt;
	}
	
	/**
	 * Finalizes the sale by sending the completed sale information to external systems.
	 */
	public void endSale() {
		intgr.sendSaleInfo(saleInstance.getDTO());
		this.ongoingPay = null;
	}
}
