package com.app.controller;

import com.app.model.*;
import com.app.integration.*;

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

}