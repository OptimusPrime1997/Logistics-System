package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.ArrivePO;
import util.enumData.GoodsArrivalState;

public class ArriveVO {
	public String order;
	public GoodsArrivalState goodsArrivalState;
	public ArriveVO(String order, GoodsArrivalState goodsArrivalState) {
		super();
		this.order = order;
		this.goodsArrivalState = goodsArrivalState;
	}
	
	public ArriveVO(ArrivePO po){
		this.order = po.getOrder();
		this.goodsArrivalState = po.getGoodsArrivalState();
	}
	
	public static ArrivePO toPO(ArriveVO vo){
		return new ArrivePO(vo.order, vo.goodsArrivalState);
	}
	
	public static ArrayList<ArriveVO> toArrayVO(ArrayList<ArrivePO> ArrivePOs){
		ArrayList<ArriveVO> ArriveVOs = new ArrayList<ArriveVO>();
		for(ArrivePO ArrivePO : ArrivePOs)
			ArriveVOs.add(new ArriveVO(ArrivePO));
		return ArriveVOs;
	}
	
	public static ArrayList<ArrivePO> toArrayPO(ArrayList<ArriveVO> ArriveVOs){
		ArrayList<ArrivePO> ArrivePOs = new ArrayList<ArrivePO>();
		for(ArriveVO ArriveVO : ArriveVOs)
			ArrivePOs.add(toPO(ArriveVO));
		return ArrivePOs;
	}
}
