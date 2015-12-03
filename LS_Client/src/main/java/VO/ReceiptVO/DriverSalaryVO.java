package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.DriverSalaryPO;

public class DriverSalaryVO extends AllSalaryVO{
	public DriverSalaryVO(String getterName, String getterNum, double money, int time) {
		super(getterName, getterNum, money);
		this.time = time;
	}

	public int time;

	public int getTime() {
		return time;
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
	
	public static ArrayList<DriverSalaryVO> toArrayVO(ArrayList<DriverSalaryPO> driverSalaryPOs){
		ArrayList<DriverSalaryVO> driverSalaryVOs = new ArrayList<DriverSalaryVO>();
		for(DriverSalaryPO driverSalaryPO : driverSalaryPOs)
			driverSalaryVOs.add(new DriverSalaryVO(driverSalaryPO));
		return driverSalaryVOs;
	}
	
	public static ArrayList<DriverSalaryPO> toArrayPO(ArrayList<DriverSalaryVO> driverSalaryVOs){
		ArrayList<DriverSalaryPO> driverSalaryPOs = new ArrayList<DriverSalaryPO>();
		for(DriverSalaryVO driverSalaryVO : driverSalaryVOs)
			driverSalaryPOs.add(DriverSalaryVO.toPO(driverSalaryVO));
		return driverSalaryPOs;
	}
}
