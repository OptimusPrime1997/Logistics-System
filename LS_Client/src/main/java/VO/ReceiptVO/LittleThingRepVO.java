package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.LittleThingRepPO;

public class LittleThingRepVO {
	public double sum;
	public String date;
	public ArrayList<LittleThingVO> littleThingVOs;
	public String bankAccountNum;
	public LittleThingRepVO(double sum, String date, ArrayList<LittleThingVO> littleThingVOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.littleThingVOs = littleThingVOs;
		this.bankAccountNum = bankAccountNum;
	}
	public LittleThingRepVO (LittleThingRepPO po){
		this.sum = po.getSum();
		this.date = po.getDate();
		this.littleThingVOs = LittleThingVO.toArrayVO(po.getLittleThingPOs());
		this.bankAccountNum = po.getBankAccountNum();
	}
	public static LittleThingRepPO toPO(LittleThingRepVO vo){
		return new LittleThingRepPO(vo.sum, vo.date, LittleThingVO.toArrayPO(vo.littleThingVOs), vo.bankAccountNum);
	}
	public static ArrayList<LittleThingRepVO> toArrayVO(ArrayList<LittleThingRepPO> LittleThingRepPOs){
		ArrayList<LittleThingRepVO> LittleThingRepVOs = new ArrayList<LittleThingRepVO>();
		for(LittleThingRepPO LittleThingRepPO : LittleThingRepPOs){
			LittleThingRepVOs.add(new LittleThingRepVO(LittleThingRepPO));
		}
		return LittleThingRepVOs;
	}
	
	public static ArrayList<LittleThingRepPO> toArrayPO(ArrayList<LittleThingRepVO> LittleThingRepVOs){
		ArrayList<LittleThingRepPO> LittleThingRepPOs = new ArrayList<LittleThingRepPO>();
		for(LittleThingRepVO LittleThingRepVO : LittleThingRepVOs){
			LittleThingRepPOs.add(LittleThingRepVO.toPO(LittleThingRepVO));
		}
		return LittleThingRepPOs;
	}
}
