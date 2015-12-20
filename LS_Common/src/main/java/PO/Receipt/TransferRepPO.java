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
	private City destination;
	private ArrayList<String> goods;
	private double money;
	private City depart;
	public TransferRepPO(String num, String date, ShipForm form, String carNum, City destination, 
			ArrayList<String> goods, double money, City depart) {
		super(num, date);
		this.form = form;
		this.carNum = carNum;
		this.destination = destination;
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
	public City getDestination() {
		return destination;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	public double getMoney() {
		return money;
	}
	public City getDepart() {
		return depart;
	}
	
}
