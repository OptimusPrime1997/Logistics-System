package bl.managementbl.salarypolicybl;

import java.util.ArrayList;

import VO.ManagementVO.SalaryPolicyVO;



public class SalaryPolicyList {
	ArrayList<SalaryPolicyVO> salaryPolicyList;
	public SalaryPolicyList(){
		salaryPolicyList=new ArrayList<SalaryPolicyVO>();
	}
	public ArrayList<SalaryPolicyVO> getSalaryPolicyList(){
		return salaryPolicyList;
	}
	public String addSalaryPolicyVO(SalaryPolicyVO SalaryPolicyVO){
		salaryPolicyList.add(SalaryPolicyVO);
		return null;
	}
	public int getSize(){
		return  salaryPolicyList.size();
	}
	public ArrayList<SalaryPolicyVO> getList(){
		return salaryPolicyList;
	}

	}
