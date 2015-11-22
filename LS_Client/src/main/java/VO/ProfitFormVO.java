package VO;

import PO.ProfitFormPO;

public class ProfitFormVO {

	public static final long serialVersionUID = 1L;
	public String timeNow;
	public double totalOut;
	public double totalIn;
	public double totalProfit;
	
	public ProfitFormVO(String timeNow, double totalOut, double totalIn,
			double totalProfit) {
		this.timeNow = timeNow;
		this.totalOut = totalOut;
		this.totalIn = totalIn;
		this.totalProfit = totalProfit;
	}
	public ProfitFormVO(ProfitFormPO po){
		this.timeNow = po.getTimeNow();
		this.totalOut = po.getTotalOut();
		this.totalIn = po.getTotalIn();
		this.totalProfit = po.getTotalProfit();
	}
	public ProfitFormPO toPO(ProfitFormVO vo){
		ProfitFormPO po=new ProfitFormPO(timeNow, totalOut, totalIn, totalProfit);
		return po;
	}
}
