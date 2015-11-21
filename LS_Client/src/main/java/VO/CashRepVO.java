package VO;

import java.util.ArrayList;

public class CashRepVO extends ReceiptVO {
	public double money;
	public String getCourierNum;
	public ArrayList<GoodsVO> goods;
	
	public CashRepVO(String num, String date, double money, String getCourierNum, ArrayList<GoodsVO> goods) {
		super(num, date);
		this.money = money;
		this.getCourierNum = getCourierNum;
		this.goods = goods;
	}
}
