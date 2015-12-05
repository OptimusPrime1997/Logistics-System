package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.PayRepRentRepPO;

public class PayRepRentRepVO {
	public ArrayList<PayRentVO> rentVOs;
	public String bankAccountNum;
	public double sum;
	public PayRepRentRepVO(ArrayList<PayRentVO> rentVOs, String bankAccountNum, double sum) {
		super();
		this.rentVOs = rentVOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public PayRepRentRepVO(PayRepRentRepPO po){
		this.rentVOs = PayRentVO.toArrayVO(po.getRentPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static PayRepRentRepPO toPO(PayRepRentRepVO vo){
		return new PayRepRentRepPO(PayRentVO.toArrayPO(vo.rentVOs), vo.bankAccountNum, vo.sum);
	}
}
