package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryRepPO;

public class SalaryRepVO extends AllSalaryRepVO{
	public ArrayList<SalaryVO> salaryVOs;

	public SalaryRepVO(String bankAccountNum, double sum, ArrayList<SalaryVO> salaryVOs) {
		super(bankAccountNum, sum);
		this.salaryVOs = salaryVOs;
	}
	public SalaryRepVO(AllSalaryRepPO po){
		this.salaryVOs = SalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static AllSalaryRepPO toPO(SalaryRepVO vo){
		return new AllSalaryRepPO(SalaryVO.toArrayPO(vo.salaryVOs), vo.bankAccountNum, vo.sum);
	}
}
