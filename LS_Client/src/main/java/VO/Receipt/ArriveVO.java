package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.ArrivePO;
import util.enumData.GoodsArrivalState;

public class ArriveVO {
	public String order;
	public GoodsArrivalState goodsArrivalState;

	public ArriveVO(String order, GoodsArrivalState goodsArrivalState) {
		super();
		this.order = order;
		this.goodsArrivalState = goodsArrivalState;
	}

	public ArriveVO(ArrivePO po) {
		this.order = po.getOrder();
		this.goodsArrivalState = po.getGoodsArrivalState();
	}

	public static ArrivePO toPO(ArriveVO vo) {
		if (vo == null)
			return null;
		return new ArrivePO(vo.order, vo.goodsArrivalState);
	}

	public static ArrayList<ArriveVO> toArrayVO(ArrayList<ArrivePO> ArrivePOs) {
		if (ArrivePOs == null)
			return null;
		ArrayList<ArriveVO> ArriveVOs = new ArrayList<ArriveVO>();
		for (ArrivePO ArrivePO : ArrivePOs)
			ArriveVOs.add(new ArriveVO(ArrivePO));
		return ArriveVOs;
	}

	public static ArrayList<ArrivePO> toArrayPO(ArrayList<ArriveVO> ArriveVOs) {
		if (ArriveVOs == null)
			return null;
		ArrayList<ArrivePO> ArrivePOs = new ArrayList<ArrivePO>();
		for (ArriveVO ArriveVO : ArriveVOs)
			ArrivePOs.add(toPO(ArriveVO));
		return ArrivePOs;
	}
}
