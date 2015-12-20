package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.PayStaffSalaryVO;
import util.enumData.Authority;

public class Staffbl{
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO){
		payRepVO.staffSalary = payRepStaffSalaryRepVO;
	}
	
	public Vector<Object> initStaffTable(){
		Vector<Object> data = new Vector<Object>();
		
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
