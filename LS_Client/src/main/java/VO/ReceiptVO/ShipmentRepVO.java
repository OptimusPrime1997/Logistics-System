package VO.ReceiptVO;

import java.util.ArrayList;

import util.enumData.*;

public class ShipmentRepVO extends ReceiptVO {
	public place place;
	public String plateNum;
	public String driverNum;
	public boolean arriveAlready;
	public ArrayList<String> goods;
	public ShipmentRepVO(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
}
