package VO.ManagementVO;

import util.enumData.SalaryPolicy;

public class SalaryPolicyVO {
	public SalaryPolicy salaryPolicy;
	public double salaryAmount;
	public SalaryPolicyVO(SalaryPolicy salaryPolicy,double salaryAmount) {
		// TODO Auto-generated constructor stub
		this.salaryPolicy=salaryPolicy;
		this.salaryAmount=salaryAmount;
		
	}
}
