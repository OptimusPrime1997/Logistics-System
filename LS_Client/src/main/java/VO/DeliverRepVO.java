package VO;

import java.util.ArrayList;

public class DeliverRepVO extends ReceiptVO {
	private String deliverCourierNum;
	private ArrayList<String> goods;

	public DeliverRepVO(String num, String date, String deliverCourierNum, ArrayList<String> goods) {
		super(num, date);
		this.deliverCourierNum = deliverCourierNum;
		this.goods = goods;
	}
}
