package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class ShippingRepPO extends ShipRepPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4435330869818621996L;
	
	private place place;

	public ShippingRepPO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods, util.enumData.place place) {
		super(num, date, plateNum, driverNum, arriveAlready, goods);
		this.place = place;
	}

	public place getPlace() {
		return place;
	}
	
}
