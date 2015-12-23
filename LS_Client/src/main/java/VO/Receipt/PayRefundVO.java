package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRefundPO;

public class PayRefundVO {
	public String reason;
	public double money;

	public PayRefundVO(String reason, double money) {
		super();
		this.reason = reason;
		this.money = money;
	}

	public PayRefundVO(PayRefundPO po) {
		this.reason = po.getReason();
		this.money = po.getMoney();
	}

	public static PayRefundPO toPO(PayRefundVO vo) {
		if (vo == null)
			return null;
		return new PayRefundPO(vo.reason, vo.money);
	}

	public static ArrayList<PayRefundVO> toArrayVO(ArrayList<PayRefundPO> littleThingPOs) {
		if (littleThingPOs == null)
			return null;
		ArrayList<PayRefundVO> littleThingVOs = new ArrayList<PayRefundVO>();
		for (PayRefundPO littleThingPO : littleThingPOs) {
			littleThingVOs.add(new PayRefundVO(littleThingPO));
		}
		return littleThingVOs;
	}

	public static ArrayList<PayRefundPO> toArrayPO(ArrayList<PayRefundVO> littleThingVOs) {
		if (littleThingVOs == null)
			return null;
		ArrayList<PayRefundPO> littleThingPOs = new ArrayList<PayRefundPO>();
		for (PayRefundVO littleThingVO : littleThingVOs) {
			littleThingPOs.add(toPO(littleThingVO));
		}
		return littleThingPOs;
	}
}