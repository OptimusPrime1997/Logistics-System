package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryRepPO;

public class DriverSalaryRepVO extends AllSalaryRepVO{
	public ArrayList<DriverSalaryVO> driverSalaryVOs;

	public DriverSalaryRepVO(String bankAccountNum, double sum, ArrayList<DriverSalaryVO> driverSalaryVOs) {
		super(bankAccountNum, sum);
		this.driverSalaryVOs = driverSalaryVOs;
	}
	public DriverSalaryRepVO(AllSalaryRepPO po){
		this.driverSalaryVOs = DriverSalaryVO.toArrayVO(po.getAllSalaryPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static AllSalaryRepPO toPO(DriverSalaryRepVO vo){
		return new AllSalaryRepPO(DriverSalaryVO.toArrayPO(vo.driverSalaryVOs), vo.bankAccountNum, vo.sum);
	}
}
