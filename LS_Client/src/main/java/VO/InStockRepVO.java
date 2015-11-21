package VO;

import java.util.ArrayList;

public class InStockRepVO extends ReceiptVO {
	public int area;
	public int loc;
	public ArrayList<String> goods;
	public InStockRepVO(String num, String date, int area, int loc, ArrayList<String> goods) {
		super(num, date);
		this.area = area;
		this.loc = loc;
		this.goods = goods;
	}
}
