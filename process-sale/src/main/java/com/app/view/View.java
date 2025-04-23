package com.app.view;
import com.app.controller.*;
import com.app.integration.*;
// import com.app.model.*;

public class View {

	private Controller contr;
	public View() {
        this.contr = contr;
		//contstructor for view

    }

	private int itemID = 2;

	public void viewScanItem(int itemID) {
		ItemInSaleDTO showItemInSale = contr.enterItem(itemID);
	}

	
}