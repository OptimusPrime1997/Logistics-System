package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.BonusPO;
import PO.ReceiptPO.SalaryPO;

public class BonusVO {
	public String getterName;
	public String getterNum;
	public double money;
	public BonusVO(String getterName, String getterNum, double money) {
		super();
		this.getterName = getterName;
		this.getterNum = getterNum;
		this.money = money;
	}
	public String getGetterName() {
		return getterName;
	}
	public String getGetterNum() {
		return getterNum;
	}
	public double getMoney() {
		return money;
	}
	public BonusVO(BonusPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
	}
	
	public static BonusPO toPO(BonusVO vo){
		return new BonusPO(vo.getterName, vo.getterNum, vo.money);
	}
	
	public static ArrayList<BonusVO> toArrayVO(ArrayList<BonusPO> bonusPOs){
		ArrayList<BonusVO> bonusVOs = new ArrayList<BonusVO>();
		for(BonusPO bonusPO : bonusPOs)
			bonusVOs.add(new BonusVO(bonusPO));
		return bonusVOs;
	}
	
	public static ArrayList<BonusPO> toArrayPO(ArrayList<BonusVO> bonusVOs){
		ArrayList<BonusPO> bonusPOs = new ArrayList<BonusPO>();
		for(BonusVO bonusVO : bonusVOs)
			bonusPOs.add(BonusVO.toPO(bonusVO));
		return bonusPOs;
	}
}
