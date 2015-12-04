package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryPO;
import PO.ReceiptPO.BonusPO;
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
	
	public static ArrayList<SalaryVO> toArrayVO(ArrayList<AllSalaryPO> allSalaryPOs){
		ArrayList<SalaryVO> SalaryVOs = new ArrayList<SalaryVO>();
		for(AllSalaryPO allSalaryPO : allSalaryPOs)
			SalaryVOs.add(new SalaryVO((SalaryPO)allSalaryPO));
		return SalaryVOs;
	}
	
	public static ArrayList<AllSalaryPO> toArrayPO(ArrayList<SalaryVO> SalaryVOs){
		ArrayList<AllSalaryPO> SalaryPOs = new ArrayList<AllSalaryPO>();
		for(SalaryVO SalaryVO : SalaryVOs)
			SalaryPOs.add(SalaryVO.toPO(SalaryVO));
		return SalaryPOs;
	}
}
