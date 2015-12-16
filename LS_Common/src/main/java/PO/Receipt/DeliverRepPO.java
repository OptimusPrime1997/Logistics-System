package PO.Receipt;

import java.util.ArrayList;

public class DeliverRepPO extends ReceiptPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7043976985716319314L;
	
	private String deliverCourierNum;
	private ArrayList<DeliverPO> deliverPOs;
	public DeliverRepPO(String num, String date, String deliverCourierNum, ArrayList<DeliverPO> deliverPOs) {
		super(num, date);
		this.deliverCourierNum = deliverCourierNum;
		this.deliverPOs = deliverPOs;
	}
	public String getDeliverCourierNum() {
		return deliverCourierNum;
	}
	public ArrayList<DeliverPO> getDeliverPOs() {
		return deliverPOs;
	}
	
}
