package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.DeliverRepPO;
import PO.ReceiptPO.ReceiptPO;

public class DeliverRepVO extends ReceiptVO {
	public String deliverCourierNum;
	public ArrayList<DeliverVO> deliverVOs;
	
	public DeliverRepVO(String num, String date, String deliverCourierNum, ArrayList<DeliverVO> deliverVOs) {
		super(num, date);
		this.deliverCourierNum = deliverCourierNum;
		this.deliverVOs = deliverVOs;
	}
	
	public DeliverRepVO(DeliverRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.deliverCourierNum = po.getDeliverCourierNum();
		this.deliverVOs = DeliverVO.toArrayVO(po.getDeliverPOs());
	}
	
	public static DeliverRepPO toPO(DeliverRepVO vo){
		return new DeliverRepPO(vo.num, vo.date, vo.deliverCourierNum, DeliverVO.toArrayPO(vo.deliverVOs));
	}
	
	public static ArrayList<DeliverRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<DeliverRepVO> DeliverRepVOs = new ArrayList<DeliverRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			DeliverRepVOs.add(new DeliverRepVO((DeliverRepPO) receiptPO));
		return DeliverRepVOs;
	}
	
	public static ArrayList<DeliverRepPO> toArrayPO(ArrayList<DeliverRepVO> DeliverRepVOs) {
		ArrayList<DeliverRepPO> DeliverRepPOs = new ArrayList<DeliverRepPO>();
		for (DeliverRepVO DeliverRepVO : DeliverRepVOs)
			DeliverRepPOs.add(DeliverRepVO.toPO(DeliverRepVO));
		return DeliverRepPOs;
	}
}
