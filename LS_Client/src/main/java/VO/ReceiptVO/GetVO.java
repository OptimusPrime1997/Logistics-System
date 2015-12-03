package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.GetPO;
import util.enumData.GoodsArrivalState;

public class GetVO {
	public String order;
	public GoodsArrivalState goodsArrivalState;
	public GetVO(String order, GoodsArrivalState goodsArrivalState) {
		super();
		this.order = order;
		this.goodsArrivalState = goodsArrivalState;
	}
	
	public GetVO(GetPO po){
		this.order = po.getOrder();
		this.goodsArrivalState = po.getGoodsArrivalState();
	}
	
	public static GetPO toPO(GetVO vo){
		return new GetPO(vo.order, vo.goodsArrivalState);
	}
	
	public static ArrayList<GetVO> toArrayVO(ArrayList<GetPO> GetPOs){
		ArrayList<GetVO> GetVOs = new ArrayList<GetVO>();
		for(GetPO GetPO : GetPOs)
			GetVOs.add(new GetVO(GetPO));
		return GetVOs;
	}
	
	public static ArrayList<GetPO> toArrayPO(ArrayList<GetVO> GetVOs){
		ArrayList<GetPO> GetPOs = new ArrayList<GetPO>();
		for(GetVO GetVO : GetVOs)
			GetPOs.add(GetVO.toPO(GetVO));
		return GetPOs;
	}
}
