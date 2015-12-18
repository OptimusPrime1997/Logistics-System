package VO;

import java.util.ArrayList;

import PO.BusinessFormPO;
import PO.Receipt.CashRepPO;
import PO.Receipt.PayRepPO;
import VO.Receipt.CashRepVO;
import VO.Receipt.CashVO;
import VO.Receipt.PayRepVO;


public class BusinessFormVO {
	public String startTime;
	public String endTime;
	public ArrayList<PayRepVO> moneyOutRecord;
	public ArrayList<ArrayList<CashRepVO>> moneyInRecord;
	
	public BusinessFormVO(String startTime, String endTime,
			ArrayList<PayRepVO> MoneyOutRecord,ArrayList<ArrayList<CashRepVO>> MoneyInRecord) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.moneyInRecord=MoneyInRecord;
		this.moneyOutRecord=MoneyOutRecord;
	}
	public BusinessFormVO(BusinessFormPO po){
		moneyInRecord=new ArrayList<ArrayList<CashRepVO>>();
		moneyOutRecord=new ArrayList<PayRepVO>();
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		for(ArrayList<CashRepPO> p:po.getMoneyInRecord()){
			this.moneyInRecord.add(CashRepVO.cashToArrayVO(p));
		}
		for(PayRepPO p:po.getMoneyOutRecord()){
			this.moneyOutRecord.add(new PayRepVO(p));
		}
	}
	
	public static BusinessFormPO toPO(BusinessFormVO vo){
		ArrayList<PayRepPO> moneyOutPOs=new ArrayList<PayRepPO>();
		ArrayList<ArrayList<CashRepPO>> moneyInPOs=new ArrayList<ArrayList<CashRepPO>>();
		for(ArrayList<CashRepVO> v:vo.moneyInRecord){
			moneyInPOs.add(CashRepVO.toArrayPO(v));
		}
		for(PayRepVO v:vo.moneyOutRecord){
			moneyOutPOs.add(PayRepVO.toPO(v));
		}
		
		BusinessFormPO po=new BusinessFormPO(vo.startTime, vo.endTime,moneyOutPOs,moneyInPOs);
		return po;
	}
	
}
