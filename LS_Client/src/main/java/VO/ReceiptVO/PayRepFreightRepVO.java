package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepFreightRepPO;

public class PayRepFreightRepVO {
	public double sum;
	public String bankAccountNum;
	public ArrayList<PayRepFreightVO> transferPayVOs;
	public PayRepFreightRepVO(double sum, String bankAccountNum, ArrayList<PayRepFreightVO> transferPayVOs) {
		super();
		this.sum = sum;
		this.bankAccountNum = bankAccountNum;
		this.transferPayVOs = transferPayVOs;
	}
	public PayRepFreightRepVO (PayRepFreightRepPO po){
		this.sum = po.getSum();
		this.bankAccountNum = po.getBankAccountNum();
		this.transferPayVOs = PayRepFreightVO.toArrayVO(po.getTransferPayPOs());
	}
	public static PayRepFreightRepPO toPO(PayRepFreightRepVO vo){
		return new PayRepFreightRepPO(vo.sum, vo.bankAccountNum, PayRepFreightVO.toArrayPO(vo.transferPayVOs));
	}
}
