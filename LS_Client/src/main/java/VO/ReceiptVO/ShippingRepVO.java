package VO.ReceiptVO;

import java.util.ArrayList;

import util.enumData.*;

public class ShippingRepVO extends ShipRepVO {
	public Place place;

	public ShippingRepVO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods, util.enumData.Place place) {
		super(num, date, plateNum, driverNum, arriveAlready, goods);
		this.place = place;
	}
	
}
