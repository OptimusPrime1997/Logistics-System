package VO.ReceiptVO;

import java.util.ArrayList;

import PO.Receipt.GetRepPO;
import PO.Receipt.ReceiptPO;
import PO.Receipt.ReceptionRepPO;
import util.enumData.City;
import util.enumData.Rep;

public class ReceptionRepVO extends ArriveRepVO{
	public City city;

	public ReceptionRepVO(String num, String date, Rep rep, String shipNum, ArrayList<ArriveVO> arriveVOs,
			City city) {
		super(num, date, rep, shipNum, arriveVOs);
		this.city = city;
	}
	
	public ReceptionRepVO(ReceptionRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.rep = po.getRep();
		this.shipNum = po.getShipNum();
		this.arriveVOs = ArriveVO.toArrayVO(po.getArrivePOs());
		this.city = po.getCity();
	}
	
	public static ReceptionRepPO toPO(ReceptionRepVO vo){
		return new ReceptionRepPO(vo.num, vo.date, vo.rep, vo.shipNum, ArriveVO.toArrayPO(vo.arriveVOs), 
				vo.city);
	}
	
	public static ArrayList<ReceptionRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<ReceptionRepVO> receptionRepVOs = new ArrayList<ReceptionRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			receptionRepVOs.add(new ReceptionRepVO((ReceptionRepPO) receiptPO));
		return receptionRepVOs;
	}
	
	public static ArrayList<ReceptionRepPO> toArrayPO(ArrayList<ReceptionRepVO> receptionRepVOs) {
		ArrayList<ReceptionRepPO> ReceptionRepPOs = new ArrayList<ReceptionRepPO>();
		for (ReceptionRepVO ReceptionRepVO : receptionRepVOs)
			ReceptionRepPOs.add(toPO(ReceptionRepVO));
		return ReceptionRepPOs;
	}
}
