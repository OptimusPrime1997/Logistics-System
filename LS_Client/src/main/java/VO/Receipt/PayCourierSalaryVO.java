package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayCourierSalaryPO;
import PO.Receipt.PaySalaryPO;

public class PayCourierSalaryVO extends PaySalaryVO{
	public int getMoneySum;
	public int deliverItemNum;
	
	public PayCourierSalaryVO(String getterName, String getterNum, double money, int getMoneySum, 
			int deliverItemNum) {
		super(getterName, getterNum, money);
		this.getMoneySum = getMoneySum;
		this.deliverItemNum = deliverItemNum;
	}

	public PayCourierSalaryVO(PayCourierSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.getMoneySum= po.getGetMoneySum();
		this.deliverItemNum = po.getDeliverItemNum();
	}
	
	public static PayCourierSalaryPO toPO(PayCourierSalaryVO vo){
		return new PayCourierSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.getMoneySum, 
				vo.deliverItemNum);
	}
	
	public static ArrayList<PayCourierSalaryVO> toArrayVO(ArrayList<PaySalaryPO> allSalaryPOs){
		ArrayList<PayCourierSalaryVO> CourierSalaryVOs = new ArrayList<PayCourierSalaryVO>();
		for(PaySalaryPO allSalaryPO : allSalaryPOs)
			CourierSalaryVOs.add(new PayCourierSalaryVO((PayCourierSalaryPO)allSalaryPO));
		return CourierSalaryVOs;
	}
	
	public static ArrayList<PaySalaryPO> toArrayPO(ArrayList<PayCourierSalaryVO> CourierSalaryVOs){
		ArrayList<PaySalaryPO> CourierSalaryPOs = new ArrayList<PaySalaryPO>();
		for(PayCourierSalaryVO CourierSalaryVO : CourierSalaryVOs)
			CourierSalaryPOs.add(toPO(CourierSalaryVO));
		return CourierSalaryPOs;
	}
}
