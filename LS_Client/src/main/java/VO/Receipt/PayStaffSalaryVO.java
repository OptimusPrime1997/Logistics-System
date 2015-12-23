package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PaySalaryPO;
import PO.Receipt.PayStaffSalaryPO;
import util.enumData.Authority;

public class PayStaffSalaryVO extends PaySalaryVO{
	public Authority authority;

	public PayStaffSalaryVO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}
	
	public PayStaffSalaryVO(PayStaffSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.authority = po.getAuthority();
	}
	
	public static PayStaffSalaryPO toPO(PayStaffSalaryVO vo){
		return new PayStaffSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.authority);
	}
	
	public static ArrayList<PayStaffSalaryVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs){
		if(allSalaryPOs==null)
			return null;
		ArrayList<PayStaffSalaryVO> SalaryVOs = new ArrayList<PayStaffSalaryVO>();
		for(PaySalaryPO allSalaryPO : allSalaryPOs)
			SalaryVOs.add(new PayStaffSalaryVO((PayStaffSalaryPO)allSalaryPO));
		return SalaryVOs;
	}
	
	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayStaffSalaryVO> SalaryVOs){
		if(SalaryVOs==null)
			return null;
		ArrayList<PaySalaryPO> SalaryPOs = new ArrayList<PaySalaryPO>();
		for(PayStaffSalaryVO SalaryVO : SalaryVOs)
			SalaryPOs.add(toPO(SalaryVO));
		return SalaryPOs;
	}
}
