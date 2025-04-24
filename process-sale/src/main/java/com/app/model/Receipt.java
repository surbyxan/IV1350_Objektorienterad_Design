package com.app.model;

import com.app.integration.*;

public class Receipt {
		//todo add the string thing
		//todo it is a bit krånglig
		private Payment pay;
		private SaleDTO saleDTO;

	public Receipt(Payment pay, SaleDTO saleDTO) {
		this.pay = pay;
		this.saleDTO = saleDTO; 
	}
	
	
}