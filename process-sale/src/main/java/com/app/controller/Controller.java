package com.app.controller;

import com.app.model.*;
import com.app.integration.*;
import com.app.view.*;

public class Controller {

	private Sale saleInstance;
	private Integration intgr;

	public Controller(Integration intgr) {
		// contstructor for controller
		this.intgr = intgr;
	}

	public void startSale(int cashierID, int customerID) {
		this.saleInstance = new Sale(cashierID, customerID);
	}

	public ItemInSaleDTO enterItem(int itemID) {

		ItemInSaleDTO itemDTOWithoutDB = saleInstance.isItemInSale(itemID);
		if (itemDTOWithoutDB != null) {

			return itemDTOWithoutDB;
		} else {
			if (!intgr.signalValidItem(itemID)) {
				return null;
			}

			ItemDTO itemDTO = intgr.fetchItemData(itemID);
			saleInstance.addItem(itemDTO);

			ItemInSaleDTO itemInSaleDTO = new ItemInSaleDTO( itemDTO, 1);
			return itemInSaleDTO;
		}
		// todo to be able to return a item dto it must call on the fetching of item
		// data method
	}

	/** REQUEST DISCOUNT **/

	public SaleDTO requestDiscount() {
		SaleDTO saleDTO = saleInstance.getDTO(); //! 1.1
		
		DiscountCollectionDTO discountData = intgr.fetchDiscount(saleDTO); //! 1.2

		saleInstance.applyDiscount(discountData); //! 1.3

		return saleInstance.getDTO();
	}

	/** PAYMENT */
	public void startPayment(View view) {
		Payment pay = saleInstance.initPayment(); //! 1.1

		view.sendPaymentInfo(pay); //! 1.2

		Receipt receipt = saleInstance.getReceipt(pay);

		intgr.printReceipt(receipt);
	}

	/**END SALE **/
	public void endSale() {
		intgr.sendSaleInfo(saleInstance.getDTO());

	}
}