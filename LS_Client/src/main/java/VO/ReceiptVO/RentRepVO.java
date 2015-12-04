package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.RentRepPO;

public class RentRepVO {
	public ArrayList<RentVO> rentVOs;
	public String bankAccountNum;
	public double sum;
	public RentRepVO(ArrayList<RentVO> rentVOs, String bankAccountNum, double sum) {
		super();
		this.rentVOs = rentVOs;
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public RentRepVO(RentRepPO po){
		this.rentVOs = RentVO.toArrayVO(po.getRentPOs());
		this.bankAccountNum = po.getBankAccountNum();
		this.sum = po.getSum();
	}
	public static RentRepPO toPO(RentRepVO vo){
		return new RentRepPO(RentVO.toArrayPO(vo.rentVOs), vo.bankAccountNum, vo.sum);
	}
}
