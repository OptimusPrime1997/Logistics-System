package VO.ReceiptVO;

import java.util.ArrayList;

import PO.Receipt.PayRepSalaryRepPO;

public class PayRepBonusRepVO extends PayRepSalaryRepVO{
	
	public ArrayList<PayBonusVO> bonusVOs;

	public PayRepBonusRepVO( String bankAccountNum, double sum,
			ArrayList<PayBonusVO> bonusVOs) {
		super(bankAccountNum, sum);
		this.bonusVOs = bonusVOs;
	}
	public PayRepBonusRepVO(PayRepSalaryRepPO po){
		this.bonusVOs = PayBonusVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static PayRepSalaryRepPO toPO(PayRepBonusRepVO vo){
		return new PayRepSalaryRepPO(PayBonusVO.toArrayPO(vo.bonusVOs),
				vo.bankAccountNum, vo.sum);
	}
}
