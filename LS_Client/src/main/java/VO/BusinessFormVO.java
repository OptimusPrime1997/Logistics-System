package VO;

import java.util.ArrayList;

import PO.BusinessFormPO;
import PO.ReceiptPO.CashRepPO;
import PO.ReceiptPO.PayRepPO;
import VO.ReceiptVO.CashRepVO;
import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.PayRepVO;


public class BusinessFormVO {
	public String startTime;
	public String endTime;
	public ArrayList<ArrayList<PayRepVO>> moneyOutRecord;
	public ArrayList<ArrayList<CashRepVO>> moneyInRecord;
	
	public BusinessFormVO(String startTime, String endTime,
			ArrayList<ArrayList<PayRepVO>> MoneyOutRecord,ArrayList<ArrayList<CashRepVO>> MoneyInRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.moneyInRecord=MoneyInRecord;
		this.moneyOutRecord=MoneyOutRecord;
	}
	public BusinessFormVO(BusinessFormPO po){
		moneyInRecord=new ArrayList<ArrayList<CashRepVO>>();
		moneyOutRecord=new ArrayList<ArrayList<PayRepVO>>();
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		for(ArrayList<CashRepPO> p:po.getMoneyInRecord()){
			this.moneyInRecord.add(CashRepVO.cashToArrayVO(p));
		}
		for(ArrayList<PayRepPO>p:po.getMoneyOutRecord()){
			this.moneyOutRecord.add(PayRepVO.payToArrayVO(p));
		}
	}
	
	public static BusinessFormPO toPO(BusinessFormVO vo){
		ArrayList<ArrayList<PayRepPO>> moneyOutPOs=new ArrayList<ArrayList<PayRepPO>>();
		ArrayList<ArrayList<CashRepPO>> moneyInPOs=new ArrayList<ArrayList<CashRepPO>>();
		for(ArrayList<CashRepVO> v:vo.moneyInRecord){
			moneyInPOs.add(CashRepVO.toArrayPO(v));
		}
		for(ArrayList<PayRepVO>v:vo.moneyOutRecord){
			moneyOutPOs.add(PayRepVO.toArrayPO(v));
		}
		
		BusinessFormPO po=new BusinessFormPO(vo.startTime, vo.endTime,moneyOutPOs,moneyInPOs);
		return po;
	}
	
}
