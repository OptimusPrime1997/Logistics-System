package VO.ManagementVO;

import util.enumData.Authority;
import util.enumData.SalaryPolicy;

public class SalaryPolicyVO implements Comparable<SalaryPolicyVO> {
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

	public int compareTo(SalaryPolicyVO v) {
		// TODO Auto-generated method stub
		return Double.compare(salaryAmount, v.salaryAmount);
	}

	public boolean equals(SalaryPolicyVO v) {
		if (authority == v.authority && salaryPolicy == v.salaryPolicy
				&& salaryAmount == v.salaryAmount) {
			return true;
		} else {
			return false;
		}
	}

}
