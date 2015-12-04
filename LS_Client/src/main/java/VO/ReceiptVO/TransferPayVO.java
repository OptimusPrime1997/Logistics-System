package VO.ReceiptVO;

import java.util.ArrayList;

import PO.ReceiptPO.TransferPayPO;

public class TransferPayVO {
	public String transferRepNum;
	public String remark;
	public double money;
	
	public TransferPayVO(String transferRepNum, String remark, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.remark = remark;
		this.money = money;
	}

	public TransferPayVO(TransferPayPO po){
		this.transferRepNum = po.getTransferRepNum();
		this.remark = po.getRemark();
		this.money = po.getMoney();
	}
	
	public static TransferPayPO toPO(TransferPayVO vo){
		return new TransferPayPO(vo.transferRepNum, vo.money, vo.remark);
	}
	
	public static ArrayList<TransferPayVO> toArrayVO(ArrayList<TransferPayPO> transferPayPOs){
		ArrayList<TransferPayVO> transferPayVOs = new  ArrayList<TransferPayVO>();
		for(TransferPayPO transferPayPO : transferPayPOs){
			transferPayVOs.add(new TransferPayVO(transferPayPO));
		}
		return transferPayVOs;
	}
	
	public static ArrayList<TransferPayPO> toArrayPO(ArrayList<TransferPayVO> transferPayVOs){
		ArrayList<TransferPayPO> transferPayPOs = new  ArrayList<TransferPayPO>();
		for(TransferPayVO transferPayVO : transferPayVOs){
			transferPayPOs.add(TransferPayVO.toPO(transferPayVO));
		}
		return transferPayPOs;
	}
	
}