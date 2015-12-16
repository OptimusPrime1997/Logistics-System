package VO.ReceiptVO;

import java.util.ArrayList;

import PO.Receipt.PayRentPO;

public class PayRentVO {
	public String getterName;
	public String phoneNum;
	public double money;
	public String remark;
	
	public PayRentVO(String getterName, String phoneNum, double money, String remark) {
		super();
		this.getterName = getterName;
		this.phoneNum = phoneNum;
		this.money = money;
		this.remark = remark;
	}
	
	public String getGetterName() {
		return getterName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public double getMoney() {
		return money;
	}

	public String getRemark() {
		return remark;
	}

	public PayRentVO(PayRentPO po){
		this.getterName = po.getGetterName();
		this.phoneNum = po.getPhoneNum();
		this.money = po.getMoney();
		this.remark = po.getRemark();
	}
	
	public static PayRentPO toPO(PayRentVO vo){
		return new PayRentPO(vo.getterName, vo.phoneNum, vo.money, vo.remark);
	}
	
	public static ArrayList<PayRentVO> toArrayVO(ArrayList<PayRentPO> rentPOs){
		ArrayList<PayRentVO> rentVOs = new ArrayList<PayRentVO>();
		for(PayRentPO rentPO : rentPOs){
			rentVOs.add(new PayRentVO(rentPO));
		}
		return rentVOs;
	}
	
	public static ArrayList<PayRentPO> toArrayPO(ArrayList<PayRentVO> rentVOs){
		ArrayList<PayRentPO> rentPOs = new ArrayList<PayRentPO>();
		for(PayRentVO rentVO : rentVOs){
			rentPOs.add(toPO(rentVO));
		}
		return rentPOs;
	}
}