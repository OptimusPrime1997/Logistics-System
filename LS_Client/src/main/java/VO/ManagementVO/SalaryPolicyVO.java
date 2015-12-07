package VO.ManagementVO;

import util.enumData.Authority;
import util.enumData.SalaryPolicy;

public class SalaryPolicyVO implements Comparable<SalaryPolicyVO> {
	public Authority authority;
	public SalaryPolicy salaryPolicy;
	public double value;

	public SalaryPolicyVO(Authority authority, SalaryPolicy salaryPolicy,
			double value) {
		super();
		this.authority = authority;
		this.salaryPolicy = salaryPolicy;
		this.value = value;
	}

	public int compareTo(SalaryPolicyVO v) {
		// TODO Auto-generated method stub
		return Double.compare(value, v.value);
	}

	public boolean equals(SalaryPolicyVO v) {
		if (authority == v.authority && salaryPolicy == v.salaryPolicy
				&& value == v.value) {
			return true;
		} else {
			return false;
		}
	}

}
