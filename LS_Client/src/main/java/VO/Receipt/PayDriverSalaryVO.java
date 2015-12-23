package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayDriverSalaryPO;
import PO.Receipt.PaySalaryPO;

public class PayDriverSalaryVO extends PaySalaryVO {

	public int time;

	public PayDriverSalaryVO(String getterName, String getterNum, double money, int time) {
		super(getterName, getterNum, money);
		this.time = time;
	}

	public PayDriverSalaryVO(PayDriverSalaryPO po) {
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.time = po.getTime();
	}

	public static PayDriverSalaryPO toPO(PayDriverSalaryVO vo) {
		if (vo == null)
			return null;
		return new PayDriverSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.time);
	}

	public static ArrayList<PayDriverSalaryVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs) {
		if (allSalaryPOs == null)
			return null;
		ArrayList<PayDriverSalaryVO> DriverSalaryVOs = new ArrayList<PayDriverSalaryVO>();
		for (PaySalaryPO allSalaryPO : allSalaryPOs)
			DriverSalaryVOs.add(new PayDriverSalaryVO((PayDriverSalaryPO) allSalaryPO));
		return DriverSalaryVOs;
	}

	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayDriverSalaryVO> DriverSalaryVOs) {
		if (DriverSalaryVOs == null)
			return null;
		ArrayList<PaySalaryPO> DriverSalaryPOs = new ArrayList<PaySalaryPO>();
		for (PayDriverSalaryVO DriverSalaryVO : DriverSalaryVOs)
			DriverSalaryPOs.add(toPO(DriverSalaryVO));
		return DriverSalaryPOs;
	}
}
