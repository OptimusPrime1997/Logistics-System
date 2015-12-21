package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.PayStaffSalaryVO;
import bl.managementbl.salarypolicybl.SalaryPolicybl;
import util.enumData.Authority;

public class Staffbl{
	
	private SalaryPolicybl salaryPolicybl = new SalaryPolicybl();
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO){
		payRepVO.staffSalary = payRepStaffSalaryRepVO;
	}
	
	public Vector<Object> initStaffTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException, 
			NumNotFoundException{
		Vector<Object> data = new Vector<Object>();
		double managerSalary = salaryPolicybl.findByAuthority(Authority.MANAGER).value;
		double fStaff_CSalary = salaryPolicybl.findByAuthority(Authority.FINANCIALSTAFF_C).value;
		double busOfficer = salaryPolicybl.findByAuthority(Authority.BUSSINESSOFFICER).value;
		double transCTROfficer = salaryPolicybl.findByAuthority(Authority.TRANSFERCTROFFICER).value;
		double warehouseSalary = salaryPolicybl.findByAuthority(Authority.WAREHOUSEMAN).value;
		double fStaff_VSalary = salaryPolicybl.findByAuthority(Authority.FINANCIALSTAFF_V).value;
		double adminSalary = salaryPolicybl.findByAuthority(Authority.ADMINISTRATOR).value;
		
		return data;
	}
	
	public Vector<Object> initStaffTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayStaffSalaryVO> payStaffSalaryVOs = payRepVO.staffSalary.salaryVOs;
		if(payStaffSalaryVOs==null)
			return data;
		PayStaffSalaryVO payStaffSalaryVO;
		for(int i = 0;i < payStaffSalaryVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payStaffSalaryVO = payStaffSalaryVOs.get(i);
			arr.add(Authority.toString(payStaffSalaryVO.authority));
			arr.add(payStaffSalaryVO.getterName);
			arr.add(payStaffSalaryVO.getterNum);
			arr.add(payStaffSalaryVO.money+"");
			data.add(arr);
		}
		return data;
	}
}
