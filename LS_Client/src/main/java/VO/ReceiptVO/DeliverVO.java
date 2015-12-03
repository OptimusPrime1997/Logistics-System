package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.DeliverPO;

public class DeliverVO {
	public String order;
	public String receiverName;
	public String receiverPhone;
	public String address;
	public DeliverVO(String order, String receiverName, String receiverPhone, String address) {
		super();
		this.order = order;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.address = address;
	}
	
	public DeliverVO(DeliverPO po){
		this.order = po.getOrder();
		this.receiverName = po.getReceiverName();
		this.receiverPhone = po.getReceiverPhone();
		this.address = po.getAddress();
	}
	
	public static DeliverPO toPO(DeliverVO vo){
		return new DeliverPO(vo.order, vo.receiverName, vo.receiverPhone, vo.address);
	}
	
	public static ArrayList<DeliverVO> toArrayVO(ArrayList<DeliverPO> DeliverPOs){
		ArrayList<DeliverVO> DeliverVOs = new ArrayList<DeliverVO>();
		for(DeliverPO DeliverPO : DeliverPOs)
			DeliverVOs.add(new DeliverVO(DeliverPO));
		return DeliverVOs;
	}
	
	public static ArrayList<DeliverPO> toArrayPO(ArrayList<DeliverVO> DeliverVOs){
		ArrayList<DeliverPO> DeliverPOs = new ArrayList<DeliverPO>();
		for(DeliverVO DeliverVO : DeliverVOs)
			DeliverPOs.add(DeliverVO.toPO(DeliverVO));
		return DeliverPOs;
	}
}
