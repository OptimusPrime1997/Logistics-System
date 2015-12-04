package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryRepPO;

public class BonusRepVO extends AllSalaryRepVO{
	
	public ArrayList<BonusVO> bonusVOs;

	public BonusRepVO(ArrayList<BonusVO> bonusVOs, String bankAccountNum, double sum) {
		super(bankAccountNum, sum);
		this.bonusVOs = bonusVOs;
	}
	public BonusRepVO(AllSalaryRepPO po){
		this.bonusVOs = BonusVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static AllSalaryRepPO toPO(BonusRepVO vo){
		return new AllSalaryRepPO(BonusVO.toArrayPO(vo.bonusVOs), vo.bankAccountNum, vo.sum);
	}
}
