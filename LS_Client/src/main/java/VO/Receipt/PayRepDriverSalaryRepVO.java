package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRepSalaryRepPO;

public class PayRepDriverSalaryRepVO extends PayRepSalaryRepVO{
	public ArrayList<PayDriverSalaryVO> driverSalaryVOs;

	public PayRepDriverSalaryRepVO(String bankAccountNum, double sum, 
			ArrayList<PayDriverSalaryVO> driverSalaryVOs) {
		super(bankAccountNum, sum);
		this.driverSalaryVOs = driverSalaryVOs;
	}
	public PayRepDriverSalaryRepVO(PayRepSalaryRepPO po){
		this.driverSalaryVOs = PayDriverSalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static PayRepSalaryRepPO toPO(PayRepDriverSalaryRepVO vo){
		return new PayRepSalaryRepPO(PayDriverSalaryVO.toArrayPO(vo.driverSalaryVOs),
				vo.bankAccountNum, vo.sum);
	}
}
