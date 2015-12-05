package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayFreightPO;

public class PayRepFreightVO {
	public String transferRepNum;
	public String remark;
	public double money;
	
	public PayRepFreightVO(String transferRepNum, String remark, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.remark = remark;
		this.money = money;
	}

	public PayRepFreightVO(PayFreightPO po){
		this.transferRepNum = po.getTransferRepNum();
		this.remark = po.getRemark();
		this.money = po.getMoney();
	}
	
	public static PayFreightPO toPO(PayRepFreightVO vo){
		return new PayFreightPO(vo.transferRepNum, vo.money, vo.remark);
	}
	
	public static ArrayList<PayRepFreightVO> toArrayVO(ArrayList<PayFreightPO> transferPayPOs){
		ArrayList<PayRepFreightVO> transferPayVOs = new  ArrayList<PayRepFreightVO>();
		for(PayFreightPO transferPayPO : transferPayPOs){
			transferPayVOs.add(new PayRepFreightVO(transferPayPO));
		}
		return transferPayVOs;
	}
	
	public static ArrayList<PayFreightPO> toArrayPO(ArrayList<PayRepFreightVO> transferPayVOs){
		ArrayList<PayFreightPO> transferPayPOs = new  ArrayList<PayFreightPO>();
		for(PayRepFreightVO transferPayVO : transferPayVOs){
			transferPayPOs.add(PayRepFreightVO.toPO(transferPayVO));
		}
		return transferPayPOs;
	}
	
}