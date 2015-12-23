package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRepSalaryRepPO;

public class PayRepCourierSalaryRepVO extends PayRepSalaryRepVO {
	public ArrayList<PayCourierSalaryVO> courierSalaryVOs;

	public PayRepCourierSalaryRepVO(String bankAccountNum, double sum, ArrayList<PayCourierSalaryVO> courierSalaryVOs) {
		super(bankAccountNum, sum);
		this.courierSalaryVOs = courierSalaryVOs;
	}

	public PayRepCourierSalaryRepVO(PayRepSalaryRepPO po) {
		if (po != null) {
			this.courierSalaryVOs = PayCourierSalaryVO.toArrayVO(po.getAllSalaryPOs());
			this.bankAccountNum = po.getBankAccountNum();
			this.sum = po.getSum();
		}
	}

	public static PayRepSalaryRepPO toPO(PayRepCourierSalaryRepVO vo) {
		if (vo == null)
			return null;
		return new PayRepSalaryRepPO(PayCourierSalaryVO.toArrayPO(vo.courierSalaryVOs), vo.bankAccountNum, vo.sum);
	}
}
