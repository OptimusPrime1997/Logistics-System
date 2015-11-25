package VO;

import java.util.ArrayList;

import PO.CourierSalaryPO;
import PO.SalaryPO;

public class CourierSalaryVO extends AllSalaryVO{
	public int getMoney;
	public int deliverItemNum;
	public CourierSalaryVO(String getterName, String getterNum, double money, int getMoney, int deliverItemNum) {
		super(getterName, getterNum, money);
		this.getMoney = getMoney;
		this.deliverItemNum = deliverItemNum;
	}
	public int getGetMoney() {
		return getMoney;
	}
	public int getDeliverItemNum() {
		return deliverItemNum;
	}
	
	public CourierSalaryVO(CourierSalaryPO po){
		this.getterName = po.getGetterName();
		this.getterNum = po.getGetterNum();
		this.money = po.getMoney();
		this.getMoney = po.getGetMoney();
		this.deliverItemNum = po.getDeliverItemNum();
	}
	
	public static CourierSalaryPO toPO(CourierSalaryVO vo){
		return new CourierSalaryPO(vo.getterName, vo.getterNum, vo.money, vo.getMoney, vo.deliverItemNum);
	}
	
	public static ArrayList<CourierSalaryVO> toArrayVO(ArrayList<CourierSalaryPO> courierSalaryPOs){
		ArrayList<CourierSalaryVO> courierSalaryVOs = new ArrayList<CourierSalaryVO>();
		for(CourierSalaryPO courierSalaryPO : courierSalaryPOs)
			courierSalaryVOs.add(new CourierSalaryVO(courierSalaryPO));
		return courierSalaryVOs;
	}
	
	public static ArrayList<CourierSalaryPO> toArrayPO(ArrayList<CourierSalaryVO> courierSalaryVOs){
		ArrayList<CourierSalaryPO> courierSalaryPOs = new ArrayList<CourierSalaryPO>();
		for(CourierSalaryVO courierSalaryVO : courierSalaryVOs)
			courierSalaryPOs.add(CourierSalaryVO.toPO(courierSalaryVO));
		return courierSalaryPOs;
	}
}
