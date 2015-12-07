package PO;

import java.io.Serializable;

import util.enumData.Authority;
import util.enumData.SalaryPolicy;

public class SalaryPolicyPO implements Serializable, Comparable<SalaryPolicyPO> {
	public final static long serialVersionUID = 1L;
	private Authority authority;
	private SalaryPolicy salaryPolicy;
	private double value;

	/**
	 * @param authority
	 * @param salaryPolicy
	 * @param value
	 */
	public SalaryPolicyPO(Authority authority, SalaryPolicy salaryPolicy,
			double value) {
		// TODO Auto-generated constructor stub
		this.authority = authority;
		this.salaryPolicy = salaryPolicy;
		this.value = value;

	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public SalaryPolicy getSalaryPolicy() {
		return salaryPolicy;
	}

	public void setSalaryPolicy(SalaryPolicy salaryPolicy) {
		this.salaryPolicy = salaryPolicy;
	}

	public double getValue() {
		return value;
	}

	public Authority getAuthority() {
		return authority;
	}

	@Override
	public int compareTo(SalaryPolicyPO o) {
		// TODO Auto-generated method stub
		return Double.compare(value, o.getValue());
	}

}
