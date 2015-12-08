package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.ArriveRepPO;
import PO.ReceiptPO.ReceiptPO;
import util.enumData.Rep;
import util.enumData.City;

public class ArriveRepVO extends ReceiptVO{
	public Rep rep;
	public String shipNum;
	public City City;
	public ArrayList<ArriveVO> arriveVOs;
	
	public ArriveRepVO(String num, String date, Rep rep, String shipNum, util.enumData.City City,
			ArrayList<ArriveVO> arriveVOs) {
		super(num, date);
		this.rep = rep;
		this.shipNum = shipNum;
		this.City = City;
		this.arriveVOs = arriveVOs;
	}
	
	public ArriveRepVO(ArriveRepPO po){
		this.date = po.getDate();
		this.num = po.getNum();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.City = po.getCity();
		this.arriveVOs = ArriveVO.toArrayVO(po.getArrivePOs());
	}
	
	public static ArriveRepPO toPO(ArriveRepVO vo){
		return new ArriveRepPO(vo.num, vo.date, vo.rep, vo.shipNum, vo.City, ArriveVO.toArrayPO(vo.arriveVOs));
	}
	
	public static ArrayList<ArriveRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<ArriveRepVO> ArriveRepVOs = new ArrayList<ArriveRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			ArriveRepVOs.add(new ArriveRepVO((ArriveRepPO) receiptPO));
		return ArriveRepVOs;
	}
	
	public static ArrayList<ArriveRepPO> toArrayPO(ArrayList<ArriveRepVO> ArriveRepVOs) {
		ArrayList<ArriveRepPO> ArriveRepPOs = new ArrayList<ArriveRepPO>();
		for (ArriveRepVO ArriveRepVO : ArriveRepVOs)
			ArriveRepPOs.add(ArriveRepVO.toPO(ArriveRepVO));
		return ArriveRepPOs;
	}
}
