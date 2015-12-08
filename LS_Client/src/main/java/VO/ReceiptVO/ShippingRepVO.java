package VO.ReceiptVO;

import java.util.ArrayList;

import util.enumData.*;

public class ShippingRepVO extends ShipRepVO {
	public City City;

	public ShippingRepVO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods, util.enumData.City City) {
		super(num, date, plateNum, driverNum, arriveAlready, goods);
		this.City = City;
	}
	
}
