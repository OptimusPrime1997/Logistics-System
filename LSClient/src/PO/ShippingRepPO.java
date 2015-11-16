package PO;

import java.util.ArrayList;

import util.enumData.*;

public class ShippingRepPO extends ReceiptPO {
	private place place;
	private String plateNum;
	private String driverNum;
	private boolean arriveAlready;
	private ArrayList<String> goods;
	public ShippingRepPO(String num, String date, place place, String plateNum, String driverNum,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.plateNum = plateNum;
		this.driverNum = driverNum;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public place getPlace() {
		return place;
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
