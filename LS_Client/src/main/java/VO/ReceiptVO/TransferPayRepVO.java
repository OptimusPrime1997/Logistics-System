package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.TransferPayRepPO;

public class TransferPayRepVO {
	public double sum;
	public String bankAccountNum;
	public ArrayList<TransferPayVO> transferPayVOs;
	public TransferPayRepVO(double sum, String bankAccountNum, ArrayList<TransferPayVO> transferPayVOs) {
		super();
		this.sum = sum;
		this.bankAccountNum = bankAccountNum;
		this.transferPayVOs = transferPayVOs;
	}
	public TransferPayRepVO (TransferPayRepPO po){
		this.sum = po.getSum();
		this.bankAccountNum = po.getBankAccountNum();
		this.transferPayVOs = TransferPayVO.toArrayVO(po.getTransferPayPOs());
	}
	public static TransferPayRepPO toPO(TransferPayRepVO vo){
		return new TransferPayRepPO(vo.sum, vo.bankAccountNum, TransferPayVO.toArrayPO(vo.transferPayVOs));
	}
}
