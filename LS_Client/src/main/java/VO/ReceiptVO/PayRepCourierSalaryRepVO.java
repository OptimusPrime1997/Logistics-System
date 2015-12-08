package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepSalaryRepPO;

public class PayRepCourierSalaryRepVO extends PayRepSalaryRepVO{
	public ArrayList<PayCourierSalaryVO> courierSalaryVOs;

	public PayRepCourierSalaryRepVO(String bankAccountNum, double sum, 
			ArrayList<PayCourierSalaryVO> courierSalaryVOs) {
		super(bankAccountNum, sum);
		this.courierSalaryVOs = courierSalaryVOs;
	}
	public PayRepCourierSalaryRepVO(PayRepSalaryRepPO po){
		this.courierSalaryVOs = PayCourierSalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static PayRepSalaryRepPO toPO(PayRepCourierSalaryRepVO vo){
		return new PayRepSalaryRepPO(PayCourierSalaryVO.toArrayPO(vo.courierSalaryVOs), 
				vo.bankAccountNum, vo.sum);
	}
}
