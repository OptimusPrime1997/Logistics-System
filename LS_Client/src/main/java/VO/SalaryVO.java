package VO;

import java.util.ArrayList;

import PO.SalaryPO;

public class SalaryVO {
	public String getterName;
	public String getterNum;
	public String date;
	public double money;
	
	public SalaryVO(String getterName, String getterNum, String date, double money) {
		super();
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.date = date;
		this.money = money;
	}

	public String getGetterName() {
		return getterName;
	}

	public String getGetterNum() {
		return getterNum;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}
	
	public SalaryVO(SalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.date = po.getDate();
		this.money = po.getMoney();
	}
	
	public static SalaryPO toPO(SalaryVO vo){
		return new SalaryPO(vo.getterName, vo.getterNum, vo.date, vo.money);
	}
	
	public static ArrayList<SalaryVO> toArrayVO(ArrayList<SalaryPO> salaryPOs){
		ArrayList<SalaryVO> salaryVOs = new ArrayList<SalaryVO>();
		for(SalaryPO salaryPO : salaryPOs)
			salaryVOs.add(new SalaryVO(salaryPO));
		return salaryVOs;
	}
	
	public static ArrayList<SalaryPO> toArrayPO(ArrayList<SalaryVO> salaryVOs){
		ArrayList<SalaryPO> salaryPOs = new ArrayList<SalaryPO>();
		for(SalaryVO salaryVO : salaryVOs)
			salaryPOs.add(SalaryVO.toPO(salaryVO));
		return salaryPOs;
	}
}