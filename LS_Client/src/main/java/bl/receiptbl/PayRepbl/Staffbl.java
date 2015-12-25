package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.ManagementVO.AccountVO;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.PayStaffSalaryVO;
import bl.managementbl.accountbl.Accountbl;
import bl.managementbl.salarypolicybl.SalaryPolicybl;
import util.enumData.Authority;

public class Staffbl{
	
	private SalaryPolicybl salaryPolicybl = new SalaryPolicybl();
	private Accountbl accountbl = new Accountbl();
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO){
		payRepVO.staffSalary = payRepStaffSalaryRepVO;
	}
	
	public Vector<Object> initStaffTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException, 
			NumNotFoundException{
		Vector<Object> data = new Vector<Object>();
		double managerSalary = 0;
		double fStaff_CSalary = 0;
		double busOfficer = 0;
		double transCTROfficer = 0;
		double warehouseSalary = 0;
		double fStaff_VSalary = 0;
		double adminSalary = 0;
		try {
			managerSalary = salaryPolicybl.findByAuthority(Authority.MANAGER).value;
		} catch (SalaryPolicyNotFoundException e) {
		}
		try {
			fStaff_CSalary = salaryPolicybl.findByAuthority(Authority.FINANCIALSTAFF_C).value;
		} catch (SalaryPolicyNotFoundException e) {
		}
		try {
			busOfficer = salaryPolicybl.findByAuthority(Authority.BUSSINESSOFFICER).value;
		} catch (SalaryPolicyNotFoundException e) {
		}
		try {
			transCTROfficer = salaryPolicybl.findByAuthority(Authority.TRANSFERCTROFFICER).value;
		} catch (SalaryPolicyNotFoundException e) {
		}
		try {
			warehouseSalary = salaryPolicybl.findByAuthority(Authority.WAREHOUSEMAN).value;
		} catch (SalaryPolicyNotFoundException e2) {
		}
		try {
			fStaff_VSalary = salaryPolicybl.findByAuthority(Authority.FINANCIALSTAFF_V).value;
		} catch (SalaryPolicyNotFoundException e1) {
		}
		try {
			adminSalary = salaryPolicybl.findByAuthority(Authority.ADMINISTRATOR).value;
		} catch (SalaryPolicyNotFoundException e) {
		}
		ArrayList<AccountVO> accountVOs = accountbl.showOther();
		for(AccountVO accountVO : accountVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(accountVO.authority.getValue());
			arr.add(accountVO.accountName);
			arr.add(accountVO.accountNum);
			switch (accountVO.authority) {
			case MANAGER:
				arr.add(managerSalary+"");
				break;
			case FINANCIALSTAFF_C:
				arr.add(fStaff_CSalary+"");
				break;
			case BUSSINESSOFFICER:
				arr.add(busOfficer+"");
				break;
			case TRANSFERCTROFFICER:
				arr.add(transCTROfficer+"");
				break;
			case WAREHOUSEMAN:
				arr.add(warehouseSalary+"");
				break;
			case FINANCIALSTAFF_V:
				arr.add(fStaff_VSalary+"");
				break;
			case ADMINISTRATOR:
				arr.add(adminSalary+"");
				break;
			default:
				break;
			}
			data.add(arr);
		}
		return data;
	}
	
	public Vector<Object> initStaffTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		PayRepStaffSalaryRepVO payRepStaffSalaryRepVO = payRepVO.staffSalary;
		if(payRepStaffSalaryRepVO==null)
			return data;
		ArrayList<PayStaffSalaryVO> payStaffSalaryVOs = payRepStaffSalaryRepVO.salaryVOs;
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
