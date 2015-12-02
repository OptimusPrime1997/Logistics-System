package VO;

import java.util.ArrayList;

import PO.CashPO;
import PO.CashRepPO;
import PO.ReceiptPO;

public class CashRepVO extends ReceiptVO {
	public double sum;
	public ArrayList<CashVO> cashVOs;

	public CashRepVO(String num, String date, ArrayList<CashVO> cashVOs, double sum) {
		super(num, date);
		this.cashVOs = cashVOs;
		this.sum = sum;
	}

	public ArrayList<CashVO> getCashRepVOs() {
		return cashVOs;
	}
	public double getSum(){
		return sum;
	}
	
	
	public static CashRepPO toPO(CashRepVO vo){
		return new CashRepPO(vo.num, vo.date, CashVO.toArrayPO(vo.cashVOs), vo.sum);
	}
	
	public CashRepVO(CashRepPO po){
		this.num = po.getNum();
		this.date = po.getDate();
		this.cashVOs = CashVO.toArrayVO(po.getCashPOs());
		this.sum = po.getSum();
	}
	
	public static ArrayList<CashRepVO> toArrayVO(ArrayList<ReceiptPO> receiptPOs) {
		ArrayList<CashRepVO> cashRepVOs = new ArrayList<CashRepVO>();
		for (ReceiptPO receiptPO : receiptPOs)
			cashRepVOs.add(new CashRepVO((CashRepPO) receiptPO));
		return cashRepVOs;
	}
	
	public static ArrayList<CashRepPO> toArrayPO(ArrayList<CashRepVO> cashRepVOs) {
		ArrayList<CashRepPO> cashRepPOs = new ArrayList<CashRepPO>();
		for (CashRepVO cashRepVO : cashRepVOs)
			cashRepPOs.add(CashRepVO.toPO(cashRepVO));
		return cashRepPOs;
	}
}
