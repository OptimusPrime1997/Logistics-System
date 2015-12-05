package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRefundPO;

public class PayRefundVO {
	public String reason;
	public double money;
	
	public PayRefundVO(String reason, double money) {
		super();
		this.reason = reason;
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public double getMoney() {
		return money;
	}

	public PayRefundVO(PayRefundPO po){
		this.reason = po.getReason();
		this.money = po.getMoney();
	}
	
	public static PayRefundPO toPO(PayRefundVO vo){
		return new PayRefundPO(vo.reason, vo.money);
	}
	
	public static ArrayList<PayRefundVO> toArrayVO(ArrayList<PayRefundPO> littleThingPOs){
		ArrayList<PayRefundVO> littleThingVOs = new ArrayList<PayRefundVO>();
		for(PayRefundPO littleThingPO : littleThingPOs){
			littleThingVOs.add(new PayRefundVO(littleThingPO));
		}
		return littleThingVOs;
	}
	
	public static ArrayList<PayRefundPO> toArrayPO(ArrayList<PayRefundVO> littleThingVOs){
		ArrayList<PayRefundPO> littleThingPOs = new ArrayList<PayRefundPO>();
		for(PayRefundVO littleThingVO : littleThingVOs){
			littleThingPOs.add(PayRefundVO.toPO(littleThingVO));
		}
		return littleThingPOs;
	}
}