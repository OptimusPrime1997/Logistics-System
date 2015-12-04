package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryRepPO;

public class CourierSalaryRepVO extends AllSalaryRepVO{
	public ArrayList<CourierSalaryVO> courierSalaryVOs;

	public CourierSalaryRepVO(String bankAccountNum, double sum, ArrayList<CourierSalaryVO> courierSalaryVOs) {
		super(bankAccountNum, sum);
		this.courierSalaryVOs = courierSalaryVOs;
	}
	public CourierSalaryRepVO(AllSalaryRepPO po){
		this.courierSalaryVOs = CourierSalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static AllSalaryRepPO toPO(CourierSalaryRepVO vo){
		return new AllSalaryRepPO(CourierSalaryVO.toArrayPO(vo.courierSalaryVOs), vo.bankAccountNum, vo.sum);
	}
}
