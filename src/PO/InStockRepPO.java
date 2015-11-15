package PO;

import java.util.ArrayList;

public class InStockRepPO extends ReceiptPO {
	private int area;
	private int loc;
	private ArrayList<String> goods;
	public InStockRepPO(String num, String date, int area, int loc, ArrayList<String> goods) {
		super(num, date);
		this.area = area;
		this.loc = loc;
		this.goods = goods;
	}
	public int getArea() {
		return area;
	}
	public int getLoc() {
		return loc;
	}
	public ArrayList<String> getGoods() {
		return goods;
	}
	
}
