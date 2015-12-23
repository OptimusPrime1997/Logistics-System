package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.InStockRepPO;
import PO.Receipt.ReceiptPO;

public class InStockRepVO extends ReceiptVO {
	public ArrayList<InStockVO> inStockVOs;

	public InStockRepVO(String num, String date, ArrayList<InStockVO> inStockVOs) {
		super(num, date);
		this.inStockVOs = inStockVOs;
	}

	public ArrayList<InStockVO> getInStockVOs() {
		return inStockVOs;
	}

	public InStockRepVO(InStockRepPO po) {
		this.date = po.getDate();
		this.num = po.getNum();
		this.inStockVOs = InStockVO.toArrayVO(po.getInStockPOs());
	}

	public static InStockRepPO toPO(InStockRepVO vo) {
		if (vo == null)
			return null;
		return new InStockRepPO(vo.num, vo.date, InStockVO.toArrayPO(vo.inStockVOs));
	}

	public static ArrayList<InStockRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		if (receiptPOs == null)
			return null;
		ArrayList<InStockRepVO> InStockRepVOs = new ArrayList<InStockRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			InStockRepVOs.add(new InStockRepVO((InStockRepPO) receiptPO));
		return InStockRepVOs;
	}

	public static ArrayList<InStockRepPO> toArrayPO(ArrayList<InStockRepVO> InStockRepVOs) {
		if (InStockRepVOs == null)
			return null;
		ArrayList<InStockRepPO> InStockRepPOs = new ArrayList<InStockRepPO>();
		for (InStockRepVO InStockRepVO : InStockRepVOs)
			InStockRepPOs.add(toPO(InStockRepVO));
		return InStockRepPOs;
	}
}
