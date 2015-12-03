package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.GetRepPO;
import PO.ReceiptPO.ReceiptPO;
import util.enumData.*;

public class GetRepVO extends ReceiptVO {
	public Rep rep;
	public String shipNum;
	public place place;
	public ArrayList<GetVO> getVOs;
	
	public GetRepVO(String num, String date, Rep rep, String shipNum, util.enumData.place place,
			ArrayList<GetVO> getVOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.place = place;
		this.getVOs = getVOs;
	}
	
	public GetRepVO(GetRepPO po){
		this.date = po.getDate();
		this.num = po.getNum();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.place = po.getPlace();
		this.getVOs = GetVO.toArrayVO(po.getGetPOs());
	}
	
	public static GetRepPO toPO(GetRepVO vo){
		return new GetRepPO(vo.num, vo.date, vo.rep, vo.shipNum, vo.place, GetVO.toArrayPO(vo.getVOs));
	}
	
	public static ArrayList<GetRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<GetRepVO> GetRepVOs = new ArrayList<GetRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			GetRepVOs.add(new GetRepVO((GetRepPO) receiptPO));
		return GetRepVOs;
	}
	
	public static ArrayList<GetRepPO> toArrayPO(ArrayList<GetRepVO> GetRepVOs) {
		ArrayList<GetRepPO> GetRepPOs = new ArrayList<GetRepPO>();
		for (GetRepVO GetRepVO : GetRepVOs)
			GetRepPOs.add(GetRepVO.toPO(GetRepVO));
		return GetRepPOs;
	}
}
