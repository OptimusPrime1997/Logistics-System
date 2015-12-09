package PO.ReceiptPO;

import java.util.ArrayList;

public class ShipRepPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2541758786513656775L;
	
	private String plateNum;
	private String driverNum;
	private ArrayList<String> goods;
	public ShipRepPO(String num, String date, String plateNum, String driverNum,
			ArrayList<String> goods) {
		super(num, date);
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.goods = goods;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}

