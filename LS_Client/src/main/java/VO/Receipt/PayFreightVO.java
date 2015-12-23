package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayFreightPO;

public class PayFreightVO {
	public String transferRepNum;
	public String remark;
	public double money;

	public PayFreightVO(String transferRepNum, String remark, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.remark = remark;
		this.money = money;
	}

	public PayFreightVO(PayFreightPO po) {
		this.transferRepNum = po.getTransferRepNum();
		this.remark = po.getRemark();
		this.money = po.getMoney();
	}

	public static PayFreightPO toPO(PayFreightVO vo) {
		if (vo == null)
			return null;
		return new PayFreightPO(vo.transferRepNum, vo.money, vo.remark);
	}

	public static ArrayList<PayFreightVO> toArrayVO(ArrayList<PayFreightPO> transferPayPOs) {
		if (transferPayPOs == null)
			return null;
		ArrayList<PayFreightVO> transferPayVOs = new ArrayList<PayFreightVO>();
		for (PayFreightPO transferPayPO : transferPayPOs) {
			transferPayVOs.add(new PayFreightVO(transferPayPO));
		}
		return transferPayVOs;
	}

	public static ArrayList<PayFreightPO> toArrayPO(ArrayList<PayFreightVO> transferPayVOs) {
		if (transferPayVOs == null)
			return null;
		ArrayList<PayFreightPO> transferPayPOs = new ArrayList<PayFreightPO>();
		for (PayFreightVO transferPayVO : transferPayVOs) {
			transferPayPOs.add(toPO(transferPayVO));
		}
		return transferPayPOs;
	}

}