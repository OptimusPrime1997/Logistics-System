package PO;

import java.util.ArrayList;
import util.enumData.*;

public class GetRepPO extends ReceiptPO {
	private String ShipNum;
	private place place;
	private GoodsArrivalState state;
	private ArrayList<String> goods;
	
	public GetRepPO(String num, String date, String shipNum, place place, GoodsArrivalState state,
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
	public GoodsArrivalState getState() {
		return state;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
	
}
