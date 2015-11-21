package VO;

import java.util.ArrayList;

import util.enumData.*;

public class GetRepVO extends ReceiptVO {
	public String ShipNum;
	public place place;
	public goodsState state;
	public ArrayList<String> goods;
	
	public GetRepVO(String num, String date, String shipNum, place place, goodsState state,
			ArrayList<String> goods) {
		super(num, date);
		ShipNum = shipNum;
		this.place = place;
		this.state = state;
		this.goods = goods;
	}
}
