package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class OutStockRepPO extends ReceiptPO{
	private place place;
	private ShipForm form;
	private String carNum;
	private String shipNum;
	private ArrayList<String> goods;
	public OutStockRepPO(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.form = form;
		this.carNum = carNum;
		this.shipNum = shipNum;
		this.goods = goods;
	}
	public place getPlace() {
		return place;
	}
	public ShipForm getForm() {
		return form;
	}
	public String getCarNum() {
		return carNum;
	}
	public String getShipNum() {
		return shipNum;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
	
}
