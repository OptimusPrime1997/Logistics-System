package PO;

import java.io.Serializable;

public class ProfitFormPO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String timeNow;
	private double totalOut;
	private double totalIn;
	private double totalProfit;
	
	public ProfitFormPO(String timeNow, double totalOut, double totalIn,
			double totalProfit) {
		this.timeNow = timeNow;
		this.totalOut = totalOut;
		this.totalIn = totalIn;
		this.totalProfit = totalProfit;
	}
	public String getTimeNow() {
		return timeNow;
	}
	public double getTotalOut() {
		return totalOut;
	}
	public double getTotalIn() {
		return totalIn;
	}
	public double getTotalProfit() {
		return totalProfit;
	}
	
}
