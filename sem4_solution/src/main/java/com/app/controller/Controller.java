package com.app.controller;

import com.app.model.*;
import com.app.integration.*;
import com.app.view.*;


import com.app.util.*;
import java.lang.RuntimeException;
import java.lang.Exception;
import java.util.List;
import java.util.ArrayList;


/**
 * The class responsible for the communication between the view layer and the model layer
 */
public class Controller {

	private Sale saleInstance;
	private Integration intgr;

	private List<Loggerlogger> loggers;
	private ErrorMessageHandler errorMessageHandler;
	private List<RevenueObserver> observers = new ArrayList<>();


	/**
	 * Constructs a new Controller with a specified integration component
	 * 
	 * @param intgr the integer component which is used
	 */
	public Controller(Integration intgr) {
		this.intgr = intgr;

		this.loggers = new ArrayList<Loggerlogger>();
		this.errorMessageHandler = new ErrorMessageHandler();

		this.observers = new ArrayList<RevenueObserver>();
		this.observers.add(new TotalRevenueFileOutput());
		this.observers.add(new TotalRevenueView());
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
	 * 
	 * @throws InvalidItemException when ItemDTO could not be found for itemID
	 */
	public ItemInSaleDTO enterItem(int itemID) throws InvalidItemException {

		ItemInSaleDTO itemDTOWithoutDB = saleInstance.isItemInSale(itemID); // ! 1.1
		if (itemDTOWithoutDB != null) {
			return itemDTOWithoutDB;
		} else {
			ItemDTO itemDTO = null;

			try {
				itemDTO = intgr.fetchItemData(itemID); // ! 1.3
			}
			catch (ItemNotFoundException itemNotFoundExc){
				throw new InvalidItemException(itemNotFoundExc.getItemID()); // ! 1.2
			} 
			catch (InventoryDatabaseException invDatabaseExc) {
				// invDatabaseExc.printStackTrace();
				for(Loggerlogger log : loggers)
					log.log(invDatabaseExc.getMessage());

				errorMessageHandler.showMessage("Failed to get item, please try again.");
			}

			if(itemDTO == null)
				return null;

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
		SaleDTO saleDTO = saleInstance.getDTO(); // ! 1.1

		DiscountCollectionDTO discountData = intgr.fetchDiscount(saleDTO); // ! 1.2

		saleInstance.applyDiscount(discountData); // ! 1.3

		return saleInstance.getDTO();
	}

	// * PAYMENT 

	/**
	 * Initiates the payment for the current sale and handles the receipt.
	 * @param view the view component responsible for handling payment interaction
 	 */
	public void startPayment(View view) {
		Payment pay = saleInstance.initPayment(); // ! 1.1

		for (RevenueObserver observer : observers) {
			pay.addObserver(observer);
		}

		view.sendPaymentInfo(pay); // ! 1.2

		pay.finalizePayment();// ! Task 2 a handled here

		Receipt receipt = saleInstance.getReceipt(pay);

		intgr.printReceipt(receipt);
	}

	// * END SALE

	/**
	 * Finalizes the sale by sending the completed sale information to external systems.
	 */
	public void endSale() {
		intgr.sendSaleInfo(saleInstance.getDTO());
	}

	

	/**
	 * Adds a logger to the list of loggers.
	 * 
	 * @param log the logger to be added.
	 */
	public void addLogger(Loggerlogger log) {
		this.loggers.add(log);
	}
}
