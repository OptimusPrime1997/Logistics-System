package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryPO;
import PO.ReceiptPO.BonusPO;
import PO.ReceiptPO.DriverSalaryPO;

public class DriverSalaryVO extends AllSalaryVO{
	
	public int time;
	
	public DriverSalaryVO(String getterName, String getterNum, double money, int time) {
		super(getterName, getterNum, money);
		this.time = time;
	}

	public DriverSalaryVO(DriverSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.time = po.getTime();
	}
	
	public static DriverSalaryPO toPO(DriverSalaryVO vo){
		return new DriverSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.time);
	}
	
	public static ArrayList<DriverSalaryVO> toArrayVO(ArrayList<AllSalaryPO> allSalaryPOs){
		ArrayList<DriverSalaryVO> DriverSalaryVOs = new ArrayList<DriverSalaryVO>();
		for(AllSalaryPO allSalaryPO : allSalaryPOs)
			DriverSalaryVOs.add(new DriverSalaryVO((DriverSalaryPO)allSalaryPO));
		return DriverSalaryVOs;
	}
	
	public static ArrayList<AllSalaryPO> toArrayPO(ArrayList<DriverSalaryVO> DriverSalaryVOs){
		ArrayList<AllSalaryPO> DriverSalaryPOs = new ArrayList<AllSalaryPO>();
		for(DriverSalaryVO DriverSalaryVO : DriverSalaryVOs)
			DriverSalaryPOs.add(DriverSalaryVO.toPO(DriverSalaryVO));
		return DriverSalaryPOs;
	}
}
