package VO.ManagementVO;

import util.enumData.Authority;
import util.enumData.SalaryPolicy;

public class SalaryPolicyVO {
	public Authority authority;
	public SalaryPolicy salaryPolicy;
	public double salaryAmount;
	public SalaryPolicyVO(Authority authority, SalaryPolicy salaryPolicy,
			double salaryAmount) {
		super();
		this.authority = authority;
		this.salaryPolicy = salaryPolicy;
		this.salaryAmount = salaryAmount;
	}
	
}
