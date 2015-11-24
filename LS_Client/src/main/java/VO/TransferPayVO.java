package VO;

import java.util.ArrayList;

import PO.TransferPayPO;

public class TransferPayVO {
	public String transferRepNum;
	public String date;
	public double money;
	
	public TransferPayVO(String transferRepNum, String date, double money) {
		super();
		this.transferRepNum = transferRepNum;
		this.date = date;
		this.money = money;
	}

	public String getTransferRepNum() {
		return transferRepNum;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}
	
	public TransferPayVO(TransferPayPO po){
		this.transferRepNum = po.getTransferRepNum();
		this.date = po.getDate();
		this.money = po.getMoney();
	}
	
	public static TransferPayPO toPO(TransferPayVO vo){
		return new TransferPayPO(vo.transferRepNum, vo.date, vo.money);
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