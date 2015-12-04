package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryPO;
import PO.ReceiptPO.BonusPO;
import PO.ReceiptPO.SalaryPO;
import util.enumData.Authority;

public class BonusVO extends AllSalaryVO{
	public String remark;
	
	public BonusVO(String getterName, String getterNum, double money, String remark) {
		super(getterName, getterNum, money);
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public BonusVO(BonusPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.remark = po.getRemark();
	}
	
	public static BonusPO toPO(BonusVO vo){
		return new BonusPO(vo.getterName, vo.getterNum, vo.money, vo.remark);
	}

	public static ArrayList<BonusVO> toArrayVO(ArrayList<AllSalaryPO> allSalaryPOs){
		ArrayList<BonusVO> bonusVOs = new ArrayList<BonusVO>();
		for(AllSalaryPO allSalaryPO : allSalaryPOs)
			bonusVOs.add(new BonusVO((BonusPO)allSalaryPO));
		return bonusVOs;
	}
	
	public static ArrayList<AllSalaryPO> toArrayPO(ArrayList<BonusVO> bonusVOs){
		ArrayList<AllSalaryPO> bonusPOs = new ArrayList<AllSalaryPO>();
		for(BonusVO bonusVO : bonusVOs)
			bonusPOs.add(BonusVO.toPO(bonusVO));
		return bonusPOs;
	}
}
