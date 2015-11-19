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
	public BusinessFormPO toPO(BusinessFormVO vo){
		BusinessFormPO po=new BusinessFormPO(startTime, endTime, moneyOutRecord, moneyInRecord);
		return po;
	}
}
