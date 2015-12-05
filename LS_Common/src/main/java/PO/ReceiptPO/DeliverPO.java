package PO.ReceiptPO;

import java.io.Serializable;

public class DeliverPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3569743276767471346L;
	
	private String order;
	private String receiverName;
	private String receiverPhone;
	private String address;
	public DeliverPO(String order, String receiverName, String receiverPhone, String address) {
		super();
		this.order = order;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.address = address;
	}
	public String getOrder() {
		return order;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public String getAddress() {
		return address;
	}
	
}
