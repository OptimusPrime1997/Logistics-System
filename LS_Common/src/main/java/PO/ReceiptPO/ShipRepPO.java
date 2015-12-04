package PO.ReceiptPO;

import java.util.ArrayList;

public class ShipRepPO extends ReceiptPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2541758786513656775L;
	
	private String plateNum;
	private String driverNum;
	private boolean arriveAlready;
	private ArrayList<String> goods;
	public ShipRepPO(String num, String date, String plateNum, String driverNum, boolean arriveAlready,
			ArrayList<String> goods) {
		super(num, date);
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public String getDriverNum() {
		return driverNum;
	}
	public boolean isArriveAlready() {
		return arriveAlready;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}

