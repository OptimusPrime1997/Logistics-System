package PO.Receipt;

import java.util.ArrayList;

import util.enumData.*;

public class TransferRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6072208742788886609L;
	
	private ShipForm form;
	private String carNum;
	private City city;
	private ArrayList<String> goods;
	private double money;
	private String depart;
	public TransferRepPO(String num, String date, ShipForm form, String carNum, City city, ArrayList<String> goods,
			double money, String depart) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.city = city;
		this.goods = goods;
		this.money = money;
		this.depart = depart;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ShipForm getForm() {
		return form;
	}
	public String getCarNum() {
		return carNum;
	}
	public City getCity() {
		return city;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	public double getMoney() {
		return money;
	}
	public String getDepart() {
		return depart;
	}
	
}
