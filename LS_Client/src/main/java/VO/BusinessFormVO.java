package VO;

import java.util.ArrayList;

import PO.BusinessFormPO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;


public class BusinessFormVO {
	public String startTime;
	public String endTime;
	public ArrayList<PayRepVO> moneyOutRecord;
	public ArrayList<CashVO> moneyInRecord;
	
	public BusinessFormVO(String startTime, String endTime,
			ArrayList<PayRepVO> MoneyOutRecord,ArrayList<CashVO> MoneyInRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.moneyInRecord=MoneyInRecord;
		this.moneyOutRecord=MoneyOutRecord;
	}
	public BusinessFormVO(BusinessFormPO po){
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		this.moneyInRecord=CashVO.toArrayVO(po.getMoneyInRecord());
		this.moneyOutRecord=PayRepVO.toArrayVO(po.getMoneyOutRecord());
	}
	public BusinessFormPO toPO(BusinessFormVO vo){
		BusinessFormPO po=new BusinessFormPO(startTime, endTime, PayRepVO.toArrayPO(moneyOutRecord),CashVO.toArrayPO(moneyInRecord));
		return po;
	}
	
}
