package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRepFreightRepPO;

public class PayRepFreightRepVO {
	public double sum;
	public String bankAccountNum;
	public ArrayList<PayFreightVO> payFreightVOs;

	public PayRepFreightRepVO(double sum, String bankAccountNum, ArrayList<PayFreightVO> payFreightVOs) {
		super();
		this.sum = sum;
		this.bankAccountNum = bankAccountNum;
		this.payFreightVOs = payFreightVOs;
	}

	public PayRepFreightRepVO(PayRepFreightRepPO po) {
		if (po != null) {
			this.sum = po.getSum();
			this.bankAccountNum = po.getBankAccountNum();
			this.payFreightVOs = PayFreightVO.toArrayVO(po.getPayFreightPOs());
		}
	}

	public static PayRepFreightRepPO toPO(PayRepFreightRepVO vo) {
		if (vo == null)
			return null;
		return new PayRepFreightRepPO(vo.sum, vo.bankAccountNum, PayFreightVO.toArrayPO(vo.payFreightVOs));
	}
}
