package VO.Receipt;

public class PayRepSalaryRepVO {
	public String bankAccountNum;
	public double sum;
	public PayRepSalaryRepVO(String bankAccountNum, double sum) {
		this.bankAccountNum = bankAccountNum;
		this.sum = sum;
	}
	public String getBankAccountNum() {
		return bankAccountNum;
	}
	public double getSum() {
		return sum;
	}
	public PayRepSalaryRepVO(){
		
	}
	
}
