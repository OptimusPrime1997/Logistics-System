package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.InStockPO;

public class InStockVO {
	public String order;
	public String area;
	public String loc;

	public InStockVO(String order, String area, String loc) {
		super();
		this.order = order;
		this.area = area;
		this.loc = loc;
	}

	public InStockVO(InStockPO po) {
		this.order = po.getOrder();
		this.area = po.getArea();
		this.loc = po.getLoc();
	}

	public static InStockPO toPO(InStockVO vo) {
		if (vo == null)
			return null;
		return new InStockPO(vo.order, vo.area, vo.loc);
	}

	public static ArrayList<InStockVO> toArrayVO(ArrayList<InStockPO> InStockPOs) {
		if (InStockPOs == null)
			return null;
		ArrayList<InStockVO> InStockVOs = new ArrayList<InStockVO>();
		for (InStockPO InStockPO : InStockPOs)
			InStockVOs.add(new InStockVO(InStockPO));
		return InStockVOs;
	}

	public static ArrayList<InStockPO> toArrayPO(ArrayList<InStockVO> InStockVOs) {
		if (InStockVOs == null)
			return null;
		ArrayList<InStockPO> InStockPOs = new ArrayList<InStockPO>();
		for (InStockVO InStockVO : InStockVOs)
			InStockPOs.add(toPO(InStockVO));
		return InStockPOs;
	}
}
