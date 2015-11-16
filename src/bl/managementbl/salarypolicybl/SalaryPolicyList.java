package bl.managementbl.salarypolicybl;

import java.util.ArrayList;



public class SalaryPolicyList {
	ArrayList<SalaryPolicyLineItem> salaryPolicyList;
	public ArrayList<SalaryPolicyLineItem> getSalaryPolicyList(){
		return salaryPolicyList;
	}
	public String addSalaryPolicyLineItem(SalaryPolicyLineItem salaryPolicyLineItem){
		salaryPolicyList.add(salaryPolicyLineItem);
		return null;
	}
	public int getSize(){
		return  salaryPolicyList.size();
	}

	}
