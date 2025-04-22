package com.app.controller;

import com.app.model.*;

public class Controller {

	private Sale saleInstance;

	public Controller( Integration Intgr ) {
		//contstructor for controller
	}

	public static void startSale( int cashierID, int customerID ) {
		this.saleInstance = new Sale( cashierID, customerID )
	}

	public static ItemDTO enterItem( int itemID ) {

	}
	

}