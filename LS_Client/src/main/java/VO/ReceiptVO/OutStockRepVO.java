package VO.ReceiptVO;

import java.util.ArrayList;

import util.enumData.*;

public class OutStockRepVO extends ReceiptVO {
	public place place;
	public ShipForm form;
	public String carNum;
	public String shipNum;
	public ArrayList<String> goods;
	public OutStockRepVO(String num, String date, place place, ShipForm form, String carNum, String shipNum,
			ArrayList<String> goods) {
		super(num, date);
		this.place = place;
		this.form = form;
		this.carNum = carNum;
		this.shipNum = shipNum;
		this.goods = goods;
	}
}
