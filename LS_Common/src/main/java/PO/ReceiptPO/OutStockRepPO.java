package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class OutStockRepPO extends ReceiptPO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5689053868789772870L;
	
	private City City;
	private ShipForm form;
	private Rep rep;
	private String shipNum;
	private ArrayList<String> goods;
	public OutStockRepPO(String num, String date, util.enumData.City City, ShipForm form, Rep rep, String shipNum,
			ArrayList<String> goods) {
		super(num, date);
		this.City = City;
		this.form = form;
		this.rep = rep;
		this.shipNum = shipNum;
		this.goods = goods;
	}
	public City getCity() {
		return City;
	}
	public ShipForm getForm() {
		return form;
	}
	public Rep getRep() {
		return rep;
	}
	public String getShipNum() {
		return shipNum;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
