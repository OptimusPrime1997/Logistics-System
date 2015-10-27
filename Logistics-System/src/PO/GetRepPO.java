package PO;

import java.util.ArrayList;

import state.goodsState;
import state.place;

public class GetRepPO extends ReceiptPO {
	private String ShipNum;
	private place place;
	private goodsState state;
	private ArrayList<String> goods;
	
	public GetRepPO(String num, String date, String shipNum, state.place place, goodsState state,
			ArrayList<String> goods) {
		super(num, date);
		ShipNum = shipNum;
		this.place = place;
		this.state = state;
		this.goods = goods;
	}
	public String getShipNum() {
		return ShipNum;
	}
	public place getPlace() {
		return place;
	}
	public goodsState getState() {
		return state;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
	
}
