package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.AllSalaryPO;
import PO.ReceiptPO.BonusPO;
import PO.ReceiptPO.CourierSalaryPO;

public class CourierSalaryVO extends AllSalaryVO{
	public int getMoneySum;
	public int deliverItemNum;
	
	public CourierSalaryVO(String getterName, String getterNum, double money, int getMoneySum, int deliverItemNum) {
		super(getterName, getterNum, money);
		this.getMoneySum = getMoneySum;
		this.deliverItemNum = deliverItemNum;
	}

	public CourierSalaryVO(CourierSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.getMoneySum= po.getGetMoneySum();
		this.deliverItemNum = po.getDeliverItemNum();
	}
	
	public static CourierSalaryPO toPO(CourierSalaryVO vo){
		return new CourierSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.getMoneySum, vo.deliverItemNum);
	}
	
	public static ArrayList<CourierSalaryVO> toArrayVO(ArrayList<AllSalaryPO> allSalaryPOs){
		ArrayList<CourierSalaryVO> CourierSalaryVOs = new ArrayList<CourierSalaryVO>();
		for(AllSalaryPO allSalaryPO : allSalaryPOs)
			CourierSalaryVOs.add(new CourierSalaryVO((CourierSalaryPO)allSalaryPO));
		return CourierSalaryVOs;
	}
	
	public static ArrayList<AllSalaryPO> toArrayPO(ArrayList<CourierSalaryVO> CourierSalaryVOs){
		ArrayList<AllSalaryPO> CourierSalaryPOs = new ArrayList<AllSalaryPO>();
		for(CourierSalaryVO CourierSalaryVO : CourierSalaryVOs)
			CourierSalaryPOs.add(CourierSalaryVO.toPO(CourierSalaryVO));
		return CourierSalaryPOs;
	}
}
