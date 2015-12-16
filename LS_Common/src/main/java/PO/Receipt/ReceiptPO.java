package PO.Receipt;

import java.io.Serializable;

public class ReceiptPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1211872896956768305L;
	
	protected String num;
	protected String date;
	
	public ReceiptPO(String num, String date) {
		this.num = num;
		this.date = date;
	}
	
	public String getNum() {
		return num;
	}
	public String getDate() {
		return date;
	}
	

}
