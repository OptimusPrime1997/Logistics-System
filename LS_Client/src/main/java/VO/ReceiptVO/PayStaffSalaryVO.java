package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PaySalaryPO;
import PO.ReceiptPO.PayBonusPO;
import PO.ReceiptPO.PayStaffSalaryPO;
import util.enumData.Authority;

public class PayStaffSalaryVO extends PaySalaryVO{
	public Authority authority;

	public PayStaffSalaryVO(String getterName, String getterNum, double money, Authority authority) {
		super(getterName, getterNum, money);
		this.authority = authority;
	}

	public Authority getAuthority() {
		return authority;
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
		ArrayList<PayStaffSalaryVO> SalaryVOs = new ArrayList<PayStaffSalaryVO>();
		for(PaySalaryPO allSalaryPO : allSalaryPOs)
			SalaryVOs.add(new PayStaffSalaryVO((PayStaffSalaryPO)allSalaryPO));
		return SalaryVOs;
	}
	
	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayStaffSalaryVO> SalaryVOs){
		ArrayList<PaySalaryPO> SalaryPOs = new ArrayList<PaySalaryPO>();
		for(PayStaffSalaryVO SalaryVO : SalaryVOs)
			SalaryPOs.add(SalaryVO.toPO(SalaryVO));
		return SalaryPOs;
	}
}
