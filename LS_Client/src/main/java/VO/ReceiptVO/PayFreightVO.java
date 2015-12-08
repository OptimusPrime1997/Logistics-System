package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayFreightPO;

public class PayFreightVO {
	public String transferRepNum;
	public String remark;
	public double money;
	
	public PayFreightVO(String transferRepNum, String remark, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.remark = remark;
		this.money = money;
	}

	public PayFreightVO(PayFreightPO po){
		this.transferRepNum = po.getTransferRepNum();
		this.remark = po.getRemark();
		this.money = po.getMoney();
	}
	
	public static PayFreightPO toPO(PayFreightVO vo){
		return new PayFreightPO(vo.transferRepNum, vo.money, vo.remark);
	}
	
	public static ArrayList<PayFreightVO> toArrayVO(ArrayList<PayFreightPO> transferPayPOs){
		ArrayList<PayFreightVO> transferPayVOs = new  ArrayList<PayFreightVO>();
		for(PayFreightPO transferPayPO : transferPayPOs){
			transferPayVOs.add(new PayFreightVO(transferPayPO));
		}
		return transferPayVOs;
	}
	
	public static ArrayList<PayFreightPO> toArrayPO(ArrayList<PayFreightVO> transferPayVOs){
		ArrayList<PayFreightPO> transferPayPOs = new  ArrayList<PayFreightPO>();
		for(PayFreightVO transferPayVO : transferPayVOs){
			transferPayPOs.add(PayFreightVO.toPO(transferPayVO));
		}
		return transferPayPOs;
	}
	
}