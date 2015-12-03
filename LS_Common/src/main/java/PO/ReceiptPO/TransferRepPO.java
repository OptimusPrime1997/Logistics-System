package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class TransferRepPO extends ReceiptPO {
	private ShipForm form;
	private String carNum;
	private place place;
	private int container;
	private boolean arriveAlready;
	private ArrayList<String> goods;
	public TransferRepPO(String num, String date, ShipForm form, String carNum, place place, int container,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.place = place;
		this.container = container;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public ShipForm getForm() {
		return form;
	}
	public String getCarNum() {
		return carNum;
	}
	public place getPlace() {
		return place;
	}
	public int getContainer() {
		return container;
	}
	public boolean isArriveAlready() {
		return arriveAlready;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
