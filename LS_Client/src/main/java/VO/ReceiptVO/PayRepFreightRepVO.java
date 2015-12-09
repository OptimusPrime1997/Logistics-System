package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepFreightRepPO;

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
	public PayRepFreightRepVO (PayRepFreightRepPO po){
		this.sum = po.getSum();
		this.bankAccountNum = po.getBankAccountNum();
		this.payFreightVOs = PayFreightVO.toArrayVO(po.getPayFreightPOs());
	}
	public static PayRepFreightRepPO toPO(PayRepFreightRepVO vo){
		return new PayRepFreightRepPO(vo.sum, vo.bankAccountNum, PayFreightVO.toArrayPO(vo.payFreightVOs));
	}
}
