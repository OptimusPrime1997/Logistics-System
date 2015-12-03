package VO.ReceiptVO;

import java.util.ArrayList;

import util.enumData.*;

public class TransferRepVO extends ReceiptVO {
	public ShipForm form;
	public String carNum;
	public place place;
	public int container;
	public boolean arriveAlready;
	public ArrayList<String> goods;
	public TransferRepVO(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.place = place;
		this.container = container;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
}
