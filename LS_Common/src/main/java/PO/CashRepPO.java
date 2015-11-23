package PO;

import java.util.ArrayList;

public class CashRepPO extends ReceiptPO {
	private double money;
	private String courierNum;
	private String courierName;
	private ArrayList<GoodsPO> goods;
	public CashRepPO(String num, String date, double money, String courierNum, String courierName,
			ArrayList<GoodsPO> goods) {
		super(num, date);
		this.money = money;
		this.courierNum = courierNum;
		this.courierName = courierName;
		this.goods = goods;
	}
	public double getMoney() {
		return money;
	}
	public String getCourierNum() {
		return courierNum;
	}
	public String getCourierName() {
		return courierName;
	}
	public ArrayList<GoodsPO> getGoods() {
		return goods;
	}
	
	
}
