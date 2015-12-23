package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.CashPO;

public class CashVO {
	public double money;
	public String courierNum;
	public String courierName;
	public String remark;

	public CashVO(double money, String courierNum, String courierName, String remark) {
		this.money = money;
		this.courierNum = courierNum;
		this.courierName = courierName;
		this.remark = remark;
	}

	public CashVO(CashPO po) {
		this.money = po.getMoney();
		this.courierNum = po.getCourierNum();
		this.courierName = po.getCourierName();
		this.remark = po.getRemark();
	}

	public static CashPO toPO(CashVO vo) {
		if (vo == null)
			return null;
		return new CashPO(vo.money, vo.courierNum, vo.courierName, vo.remark);
	}

	public static ArrayList<CashVO> toArrayVO(ArrayList<CashPO> cashPOs) {
		if (cashPOs == null)
			return null;
		ArrayList<CashVO> cashVOs = new ArrayList<CashVO>();
		for (CashPO cashPO : cashPOs)
			cashVOs.add(new CashVO(cashPO));
		return cashVOs;
	}

	public static ArrayList<CashPO> toArrayPO(ArrayList<CashVO> cashVOs) {
		if (cashVOs == null)
			return null;
		ArrayList<CashPO> cashPOs = new ArrayList<CashPO>();
		for (CashVO cashVO : cashVOs)
			cashPOs.add(toPO(cashVO));
		return cashPOs;
	}
}
