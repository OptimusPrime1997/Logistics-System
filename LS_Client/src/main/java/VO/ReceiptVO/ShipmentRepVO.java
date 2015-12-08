package VO.ReceiptVO;

import java.util.ArrayList;

public class ShipmentRepVO extends ShipRepVO {

	public ShipmentRepVO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods){
		super(num, date, plateNum, driverNum, arriveAlready, goods);
	}
}
