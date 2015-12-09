package PO.ReceiptPO;

import java.util.ArrayList;

public class ShippingRepPO extends ShipRepPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4435330869818621996L;
	
	private String destination;

	public ShippingRepPO(String num, String date, String plateNum, String driverNum,
			ArrayList<String> goods, String destination) {
		super(num, date, plateNum, driverNum, goods);
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}
	
}
