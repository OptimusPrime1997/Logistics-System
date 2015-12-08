package PO.ReceiptPO;

import java.util.ArrayList;

import util.enumData.*;

public class TransferRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6072208742788886609L;
	
	private ShipForm form;
	private String carNum;
	private City City;
	private boolean arriveAlready;
	private ArrayList<String> goods;
	public TransferRepPO(String num, String date, ShipForm form, String carNum, City City,
			boolean arriveAlready, ArrayList<String> goods) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.City = City;
		this.arriveAlready = arriveAlready;
		this.goods = goods;
	}
	public ShipForm getForm() {
		return form;
	}
	public String getCarNum() {
		return carNum;
	}
	public City getCity() {
		return City;
	}
	public boolean isArriveAlready() {
		return arriveAlready;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
