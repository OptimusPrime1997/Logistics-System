package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PaySalaryPO;
import PO.ReceiptPO.PayBonusPO;
import PO.ReceiptPO.PayRepDriverSalaryPO;

public class PayDriverSalaryVO extends PaySalaryVO{
	
	public int time;
	
	public PayDriverSalaryVO(String getterName, String getterNum, double money, int time) {
		super(getterName, getterNum, money);
		this.time = time;
	}

	public PayDriverSalaryVO(PayRepDriverSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.time = po.getTime();
	}
	
	public static PayRepDriverSalaryPO toPO(PayDriverSalaryVO vo){
		return new PayRepDriverSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.time);
	}
	
	public static ArrayList<PayDriverSalaryVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs){
		ArrayList<PayDriverSalaryVO> DriverSalaryVOs = new ArrayList<PayDriverSalaryVO>();
		for(PaySalaryPO allSalaryPO : allSalaryPOs)
			DriverSalaryVOs.add(new PayDriverSalaryVO((PayRepDriverSalaryPO)allSalaryPO));
		return DriverSalaryVOs;
	}
	
	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayDriverSalaryVO> DriverSalaryVOs){
		ArrayList<PaySalaryPO> DriverSalaryPOs = new ArrayList<PaySalaryPO>();
		for(PayDriverSalaryVO DriverSalaryVO : DriverSalaryVOs)
			DriverSalaryPOs.add(DriverSalaryVO.toPO(DriverSalaryVO));
		return DriverSalaryPOs;
	}
}