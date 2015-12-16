package VO.ReceiptVO;

import java.util.ArrayList;

import PO.Receipt.PayRepSalaryRepPO;

public class PayRepStaffSalaryRepVO extends PayRepSalaryRepVO{
	public ArrayList<PayStaffSalaryVO> salaryVOs;

	public PayRepStaffSalaryRepVO(String bankAccountNum, double sum, 
			ArrayList<PayStaffSalaryVO> salaryVOs) {
		super(bankAccountNum, sum);
		this.salaryVOs = salaryVOs;
	}
	public PayRepStaffSalaryRepVO(PayRepSalaryRepPO po){
		this.salaryVOs = PayStaffSalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static PayRepSalaryRepPO toPO(PayRepStaffSalaryRepVO vo){
		return new PayRepSalaryRepPO(PayStaffSalaryVO.toArrayPO(vo.salaryVOs),
				vo.bankAccountNum, vo.sum);
	}
}
