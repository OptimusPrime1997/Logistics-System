package blservice.receiptblservice;

import java.util.ArrayList;

import VO.ShipmentRepVO;

public interface ShipmentRepblServce {
	public ShipmentRepVO getShipmentRep(String num);
	
	public String submit(String num, String date, util.enumData.place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods);

	public ArrayList<ShipmentRepVO> forpay();
}
