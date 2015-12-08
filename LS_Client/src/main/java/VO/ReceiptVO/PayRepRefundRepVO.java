package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepRefundRepPO;

public class PayRepRefundRepVO {
	public double sum;
	public String date;
	public ArrayList<PayRefundVO> littleThingVOs;
	public String bankAccountNum;
	public PayRepRefundRepVO(double sum, String date, ArrayList<PayRefundVO> littleThingVOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.littleThingVOs = littleThingVOs;
		this.bankAccountNum = bankAccountNum;
	}
	public PayRepRefundRepVO (PayRepRefundRepPO po){
		this.sum = po.getSum();
		this.date = po.getDate();
		this.littleThingVOs = PayRefundVO.toArrayVO(po.getRefundPOs());
		this.bankAccountNum = po.getBankAccountNum();
	}
	public static PayRepRefundRepPO toPO(PayRepRefundRepVO vo){
		return new PayRepRefundRepPO(vo.sum, vo.date, PayRefundVO.toArrayPO(vo.littleThingVOs), vo.bankAccountNum);
	}
	public static ArrayList<PayRepRefundRepVO> toArrayVO(ArrayList<PayRepRefundRepPO> LittleThingRepPOs){
		ArrayList<PayRepRefundRepVO> LittleThingRepVOs = new ArrayList<PayRepRefundRepVO>();
		for(PayRepRefundRepPO LittleThingRepPO : LittleThingRepPOs){
			LittleThingRepVOs.add(new PayRepRefundRepVO(LittleThingRepPO));
		}
		return LittleThingRepVOs;
	}
	
	public static ArrayList<PayRepRefundRepPO> toArrayPO(ArrayList<PayRepRefundRepVO> LittleThingRepVOs){
		ArrayList<PayRepRefundRepPO> LittleThingRepPOs = new ArrayList<PayRepRefundRepPO>();
		for(PayRepRefundRepVO LittleThingRepVO : LittleThingRepVOs){
			LittleThingRepPOs.add(LittleThingRepVO.toPO(LittleThingRepVO));
		}
		return LittleThingRepPOs;
	}
}
