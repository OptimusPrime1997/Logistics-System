package PO;

import java.util.ArrayList;
import VO.*;

public class CashRepPO extends ReceiptPO {
	private int money;
	private String getCourierNum;
	private ArrayList<GoodsVO> goods;
	
	public CashRepPO(String num, String date, int money, String getCourierNum, ArrayList<GoodsVO> goods) {
		super(num, date);
		this.money = money;
		this.getCourierNum = getCourierNum;
		this.goods = goods;
	}

	public int getMoney() {
		return money;
	}

	public String getGetCourierNum() {
		return getCourierNum;
	}

	public ArrayList<GoodsVO> getGoods() {
		return goods;
	}

	
}
