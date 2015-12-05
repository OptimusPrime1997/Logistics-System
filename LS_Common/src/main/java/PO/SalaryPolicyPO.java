package PO;

import java.io.Serializable;

import util.enumData.Authority;
import util.enumData.SalaryPolicy;

public class SalaryPolicyPO implements Serializable, Comparable<SalaryPolicyPO> {
	public final static long serialVersionUID = 1L;
	private Authority authority;
	private SalaryPolicy salaryPolicy;
	private double salaryAmount;

	/**
	 * @param authority
	 * @param salaryPolicy
	 * @param salaryAmount
	 */
	public SalaryPolicyPO(Authority authority, SalaryPolicy salaryPolicy,
			double salaryAmount) {
		// TODO Auto-generated constructor stub
		this.authority = authority;
		this.salaryPolicy = salaryPolicy;
		this.salaryAmount = salaryAmount;

	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public void setSalaryAmount(double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public SalaryPolicy getSalaryPolicy() {
		return salaryPolicy;
	}

	public void setSalaryPolicy(SalaryPolicy salaryPolicy) {
		this.salaryPolicy = salaryPolicy;
	}

	public double getSalaryAmount() {
		return salaryAmount;
	}

	public Authority getAuthority() {
		return authority;
	}

	@Override
	public int compareTo(SalaryPolicyPO o) {
		// TODO Auto-generated method stub
		return Double.compare(salaryAmount, o.getSalaryAmount());
	}

}
