package VO;

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
}
