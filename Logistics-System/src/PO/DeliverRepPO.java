package PO;

import java.util.ArrayList;

public class DeliverRepPO extends ReceiptPO {
	private String deliverCourierNum;
	private ArrayList<String> goods;

	public DeliverRepPO(String num, String date, String deliverCourierNum, ArrayList<String> goods) {
		super(num, date);
		this.deliverCourierNum = deliverCourierNum;
		this.goods = goods;
	}

	public String getDeliverCourierNum() {
		return deliverCourierNum;
	}

	public ArrayList<String> getGoods() {
		return goods;
	}

}
