package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRepSalaryRepPO;

public class PayRepStaffSalaryRepVO extends PayRepSalaryRepVO {
	public ArrayList<PayStaffSalaryVO> salaryVOs;

	public PayRepStaffSalaryRepVO(String bankAccountNum, double sum, ArrayList<PayStaffSalaryVO> salaryVOs) {
		super(bankAccountNum, sum);
		this.salaryVOs = salaryVOs;
	}

	public PayRepStaffSalaryRepVO(PayRepSalaryRepPO po) {
		if (po != null) {
			this.salaryVOs = PayStaffSalaryVO.toArrayVO(po.getAllSalaryPOs());
			this.bankAccountNum = po.getBankAccountNum();
			this.sum = po.getSum();
		}
	}

	public static PayRepSalaryRepPO toPO(PayRepStaffSalaryRepVO vo) {
		if (vo == null)
			return null;
		return new PayRepSalaryRepPO(PayStaffSalaryVO.toArrayPO(vo.salaryVOs), vo.bankAccountNum, vo.sum);
	}
}
