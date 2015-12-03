package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.SalaryPO;
import util.enumData.Authority;

public class SalaryVO extends AllSalaryVO{
	public Authority authority;

	public SalaryVO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}

	public Authority getAuthority() {
		return authority;
	}
	
	public SalaryVO(SalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.authority = po.getAuthority();
	}
	
	public static SalaryPO toPO(SalaryVO vo){
		return new SalaryPO(vo.getterName, vo.getterNum, vo.money, vo.authority);
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
