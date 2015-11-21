package VO;

import java.util.ArrayList;

import util.enumData.*;

public class ReceptionRepVO extends ReceiptVO {
	public place place;
	public String shipNum;
	public goodsState state;
	public ArrayList<String> goods;
	public ReceptionRepVO(String num, String date, place place, String shipNum, goodsState state,
			ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.shipNum = shipNum;
		this.state = state;
		this.goods = goods;
	}
}
