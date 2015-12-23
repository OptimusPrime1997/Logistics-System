package VO.Receipt;

import java.util.ArrayList;

import PO.Receipt.PayRepRefundRepPO;

public class PayRepRefundRepVO {
	public double sum;
	public String date;
	public ArrayList<PayRefundVO> refundVOs;
	public String bankAccountNum;

	public PayRepRefundRepVO(double sum, String date, ArrayList<PayRefundVO> refundVOs, String bankAccountNum) {
		super();
		this.sum = sum;
		this.date = date;
		this.refundVOs = refundVOs;
		this.bankAccountNum = bankAccountNum;
	}

	public PayRepRefundRepVO(PayRepRefundRepPO po) {
		this.sum = po.getSum();
		this.date = po.getDate();
		this.refundVOs = PayRefundVO.toArrayVO(po.getRefundPOs());
		this.bankAccountNum = po.getBankAccountNum();
	}

	public static PayRepRefundRepPO toPO(PayRepRefundRepVO vo) {
		if (vo == null)
			return null;
		return new PayRepRefundRepPO(vo.sum, vo.date, PayRefundVO.toArrayPO(vo.refundVOs), vo.bankAccountNum);
	}

	public static ArrayList<PayRepRefundRepVO> toArrayVO(ArrayList<PayRepRefundRepPO> payRepRefundRepPOs) {
		if (payRepRefundRepPOs == null)
			return null;
		ArrayList<PayRepRefundRepVO> payRepRefundRepVOs = new ArrayList<PayRepRefundRepVO>();
		for (PayRepRefundRepPO payRepRefundRepPO : payRepRefundRepPOs) {
			payRepRefundRepVOs.add(new PayRepRefundRepVO(payRepRefundRepPO));
		}
		return payRepRefundRepVOs;
	}

	public static ArrayList<PayRepRefundRepPO> toArrayPO(ArrayList<PayRepRefundRepVO> payRepRefundRepVOs) {
		if (payRepRefundRepVOs == null)
			return null;
		ArrayList<PayRepRefundRepPO> payRepRefundRepPOs = new ArrayList<PayRepRefundRepPO>();
		for (PayRepRefundRepVO payRepRefundRepVO : payRepRefundRepVOs) {
			payRepRefundRepPOs.add(toPO(payRepRefundRepVO));
		}
		return payRepRefundRepPOs;
	}
}
