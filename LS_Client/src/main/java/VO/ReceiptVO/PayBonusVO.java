package VO.ReceiptVO;

import java.util.ArrayList;

import PO.Receipt.PayBonusPO;
import PO.Receipt.PaySalaryPO;

public class PayBonusVO extends PaySalaryVO{
	public String remark;
	
	public PayBonusVO(String getterName, String getterNum, double money, String remark) {
		super(getterName, getterNum, money);
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public PayBonusVO(PayBonusPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.remark = po.getRemark();
	}
	
	public static PayBonusPO toPO(PayBonusVO vo){
		return new PayBonusPO(vo.getterName, vo.getterNum, vo.money, vo.remark);
	}

	public static ArrayList<PayBonusVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs){
		ArrayList<PayBonusVO> bonusVOs = new ArrayList<PayBonusVO>();
		for(PaySalaryPO allSalaryPO : allSalaryPOs)
			bonusVOs.add(new PayBonusVO((PayBonusPO)allSalaryPO));
		return bonusVOs;
	}
	
	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayBonusVO> bonusVOs){
		ArrayList<PaySalaryPO> bonusPOs = new ArrayList<PaySalaryPO>();
		for(PayBonusVO bonusVO : bonusVOs)
			bonusPOs.add(toPO(bonusVO));
		return bonusPOs;
	}
}
