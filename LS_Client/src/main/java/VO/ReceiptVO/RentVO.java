package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.RentPO;

public class RentVO {
	public String getterName;
	public String phoneNum;
	public double money;
	public String date;
	
	public RentVO(String getterName, String phoneNum, double money, String date) {
		super();
		this.getterName = getterName;
		this.phoneNum = phoneNum;
		this.money = money;
		this.date = date;
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

	public String getDate() {
		return date;
	}
	
	public RentVO(RentPO po){
		this.getterName = po.getGetterName();
		this.phoneNum = po.getPhoneNum();
		this.money = po.getMoney();
		this.date = po.getDate();
	}
	
	public static RentPO toPO(RentVO vo){
		return new RentPO(vo.getterName, vo.phoneNum, vo.money, vo.date);
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