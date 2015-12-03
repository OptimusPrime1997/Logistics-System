package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class ReceptionRepPO extends ReceiptPO {
	private place place;
	private String shipNum;
	private GoodsArrivalState state;
	private ArrayList<String> goods;
	public ReceptionRepPO(String num, String date, place place, String shipNum, GoodsArrivalState state,
			ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.shipNum = shipNum;
		this.state = state;
		this.goods = goods;
	}
	public place getPlace() {
		return place;
	}
	public String getShipNum() {
		return shipNum;
	}
	public GoodsArrivalState getState() {
		return state;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
