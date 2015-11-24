package VO;

import java.util.ArrayList;

import PO.BusinessFormPO;


public class BusinessFormVO {
	public String startTime;
	public String endTime;
	public ArrayList<PayRepVO> moneyOutRecord;
	public ArrayList<CashRepVO> moneyInRecord;
	
	public BusinessFormVO(String startTime, String endTime,
			ArrayList<PayRepVO> MoneyOutRecord,ArrayList<CashRepVO> MoneyInRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.moneyInRecord=MoneyInRecord;
		this.moneyOutRecord=MoneyOutRecord;
	}
	public BusinessFormVO(BusinessFormPO po){
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		this.moneyInRecord=CashRepVO.toVOArray(po.getMoneyInRecord());
		this.moneyOutRecord=PayRepVO.toArrayVO(po.getMoneyOutRecord());
	}
	public BusinessFormPO toPO(BusinessFormVO vo){
		BusinessFormPO po=new BusinessFormPO(startTime, endTime, PayRepVO.toArrayPO(moneyOutRecord),CashRepVO.toArrayPO(moneyInRecord));
		return po;
	}
	
}
