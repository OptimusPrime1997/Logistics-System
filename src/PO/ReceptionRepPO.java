package PO;

import java.util.ArrayList;

import state.goodsState;
import state.place;

public class ReceptionRepPO extends ReceiptPO {
	private place place;
	private String shipNum;
	private goodsState state;
	private ArrayList<String> goods;
	public ReceptionRepPO(String num, String date, state.place place, String shipNum, goodsState state,
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
	public goodsState getState() {
		return state;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
