package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayCourierSalaryPO;
import PO.Receipt.PaySalaryPO;

public class PayCourierSalaryVO extends PaySalaryVO {
	public double workMoney;

	public PayCourierSalaryVO(String getterName, String getterNum, double money, double workMoney) {
		super(getterName, getterNum, money);
		this.workMoney = workMoney;
	}

	public PayCourierSalaryVO(PayCourierSalaryPO po) {
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.workMoney = po.getWorkMoney();
	}

	public static PayCourierSalaryPO toPO(PayCourierSalaryVO vo) {
		if (vo == null)
			return null;
		return new PayCourierSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.workMoney);
	}

	public static ArrayList<PayCourierSalaryVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs) {
		if (allSalaryPOs == null)
			return null;
		ArrayList<PayCourierSalaryVO> CourierSalaryVOs = new ArrayList<PayCourierSalaryVO>();
		for (PaySalaryPO allSalaryPO : allSalaryPOs)
			CourierSalaryVOs.add(new PayCourierSalaryVO((PayCourierSalaryPO) allSalaryPO));
		return CourierSalaryVOs;
	}

	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayCourierSalaryVO> CourierSalaryVOs) {
		if (CourierSalaryVOs == null)
			return null;
		ArrayList<PaySalaryPO> CourierSalaryPOs = new ArrayList<PaySalaryPO>();
		for (PayCourierSalaryVO CourierSalaryVO : CourierSalaryVOs)
			CourierSalaryPOs.add(toPO(CourierSalaryVO));
		return CourierSalaryPOs;
	}
}
