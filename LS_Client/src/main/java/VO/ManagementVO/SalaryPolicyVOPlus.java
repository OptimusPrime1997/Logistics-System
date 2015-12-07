package VO.ManagementVO;

import util.enumData.Authority;
import util.enumData.ModifyState;
import util.enumData.SalaryPolicy;

public class SalaryPolicyVOPlus extends SalaryPolicyVO {
	public ModifyState isModify;
	public SalaryPolicyVOPlus(Authority authority, SalaryPolicy salaryPolicy,
			double salaryAmount,ModifyState isModify) {
		super(authority, salaryPolicy, salaryAmount);
		// TODO Auto-generated constructor stub
		this.isModify=isModify;
	}
	public SalaryPolicyVOPlus(SalaryPolicyVO v,ModifyState isModify){
		super(v.authority, v.salaryPolicy, v.salaryAmount);
		this.isModify=isModify;
	}
public SalaryPolicyVO getSalaryPolicyVO(){
	return new SalaryPolicyVO(authority, salaryPolicy, salaryAmount);
}
}
