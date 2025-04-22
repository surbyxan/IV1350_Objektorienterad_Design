package com.app.controller;

import com.app.model.*;
import com.app.integration.*;

public class Controller {

	private Sale saleInstance;
	private Integration Intgr;

	public Controller( Integration Intgr ) {
		//contstructor for controller
		this.Intgr = new Integration();	
	}

	public void startSale( int cashierID, int customerID ) {
		this.saleInstance = new Sale( cashierID, customerID );
	}

	public ItemDTO enterItem( int itemID ) {

		ItemDTO itemDTOWithoutDB = saleInstance.isItemInSale(itemID);
		if (itemDTOWithoutDB != null){
			return itemDTOWithoutDB;
		}else{

			if (!Intgr.signalValidItem(itemID)){
				return null;
			}

			ItemDTO itemDTO = Intgr.fetchItemData(itemID);

			saleInstance.addItem(itemDTO);

			return itemDTO;
		}
		//todo to be able to return a item dto it must call on the fetching of item data method
	}
	

}