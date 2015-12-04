package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.LittleThingPO;

public class LittleThingVO {
	public String reason;
	public double money;
	
	public LittleThingVO(String reason, double money) {
		super();
		this.reason = reason;
		this.money = money;
	}

	public String getReason() {
		return reason;
	}

	public double getMoney() {
		return money;
	}

	public LittleThingVO(LittleThingPO po){
		this.reason = po.getReason();
		this.money = po.getMoney();
	}
	
	public static LittleThingPO toPO(LittleThingVO vo){
		return new LittleThingPO(vo.reason, vo.money);
	}
	
	public static ArrayList<LittleThingVO> toArrayVO(ArrayList<LittleThingPO> littleThingPOs){
		ArrayList<LittleThingVO> littleThingVOs = new ArrayList<LittleThingVO>();
		for(LittleThingPO littleThingPO : littleThingPOs){
			littleThingVOs.add(new LittleThingVO(littleThingPO));
		}
		return littleThingVOs;
	}
	
	public static ArrayList<LittleThingPO> toArrayPO(ArrayList<LittleThingVO> littleThingVOs){
		ArrayList<LittleThingPO> littleThingPOs = new ArrayList<LittleThingPO>();
		for(LittleThingVO littleThingVO : littleThingVOs){
			littleThingPOs.add(LittleThingVO.toPO(littleThingVO));
		}
		return littleThingPOs;
	}
}