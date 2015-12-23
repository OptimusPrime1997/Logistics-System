package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayCourierSalaryPO;
import PO.Receipt.PaySalaryPO;

public class PayCourierSalaryVO extends PaySalaryVO {
	public double getMoneySum;
	public double deliverMoneySum;

	public PayCourierSalaryVO(String getterName, String getterNum, double money, double getMoneySum,
			double deliverMoneySum) {
		super(getterName, getterNum, money);
		this.getMoneySum = getMoneySum;
		this.deliverMoneySum = deliverMoneySum;
	}

	public PayCourierSalaryVO(PayCourierSalaryPO po) {
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.getMoneySum = po.getGetMoneySum();
		this.deliverMoneySum = po.getDeliverMoneySum();
	}

	public static PayCourierSalaryPO toPO(PayCourierSalaryVO vo) {
		if (vo == null)
			return null;
		return new PayCourierSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.getMoneySum, vo.deliverMoneySum);
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
