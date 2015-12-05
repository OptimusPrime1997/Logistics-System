package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.RentPO;

public class RentVO {
	public String getterName;
	public String phoneNum;
	public double money;
	public String remark;
	
	public RentVO(String getterName, String phoneNum, double money, String remark) {
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

	public RentVO(RentPO po){
		this.getterName = po.getGetterName();
		this.phoneNum = po.getPhoneNum();
		this.money = po.getMoney();
		this.remark = po.getRemark();
	}
	
	public static RentPO toPO(RentVO vo){
		return new RentPO(vo.getterName, vo.phoneNum, vo.money, vo.remark);
	}
	
	public static ArrayList<RentVO> toArrayVO(ArrayList<RentPO> rentPOs){
		ArrayList<RentVO> rentVOs = new ArrayList<RentVO>();
		for(RentPO rentPO : rentPOs){
			rentVOs.add(new RentVO(rentPO));
		}
		return rentVOs;
	}
	
	public static ArrayList<RentPO> toArrayPO(ArrayList<RentVO> rentVOs){
		ArrayList<RentPO> rentPOs = new ArrayList<RentPO>();
		for(RentVO rentVO : rentVOs){
			rentPOs.add(RentVO.toPO(rentVO));
		}
		return rentPOs;
	}
}