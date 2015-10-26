package PO;

import java.io.Serializable;

public class SalaryPolicyPO implements Serializable{
	public final static long serialVersionUID=1L;
		
		private String salaryPolicy;
		private String salaryAmount;
		public SalaryPolicyPO(String salaryPolicy,String salaryAmount) {
			// TODO Auto-generated constructor stub
			this.salaryPolicy=salaryPolicy;
			this.salaryAmount=salaryAmount;
			
		}

				public String getSalaryPolicy() {
			return salaryPolicy;
		}

		public void setSalaryPolicy(String salaryPolicy) {
			this.salaryPolicy = salaryPolicy;
		}

		public String getSalaryAmount() {
			return salaryAmount;
		}

		public void setSalaryAmount(String salaryAmount) {
			this.salaryAmount = salaryAmount;
		}

	}

