package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayPO;

public class PayVO {
	public String payThing;
	public double money;
	public String bankAccountNum;
	public String remark;
	public PayVO(String payThing, double money, String bankAccountNum, String remark) {
		super();
		this.payThing = payThing;
		this.money = money;
		this.bankAccountNum = bankAccountNum;
		this.remark = remark;
	}
	public PayVO(PayPO po){
		this.payThing = po.getPayThing();
		this.money = po.getMoney();
		this.bankAccountNum = po.getBankAccountNum();
		this.remark = po.getRemark();
	}
	public static PayPO toPO(PayVO vo){
		return new PayPO(vo.payThing, vo.money, vo.bankAccountNum, vo.remark);
	}
	public static ArrayList<PayVO> toArrayVO(ArrayList<PayPO> PayPOs){
		if(PayPOs==null)
			return null;
		ArrayList<PayVO> PayVOs = new ArrayList<PayVO>();
		for(PayPO PayPO : PayPOs)
			PayVOs.add(new PayVO(PayPO));
		return PayVOs;
	}
	
	public static ArrayList<PayPO> toArrayPO(ArrayList<PayVO> PayVOs){
		ArrayList<PayPO> PayPOs = new ArrayList<PayPO>();
		for(PayVO PayVO : PayVOs)
			PayPOs.add(toPO(PayVO));
		return PayPOs;
	}
}
