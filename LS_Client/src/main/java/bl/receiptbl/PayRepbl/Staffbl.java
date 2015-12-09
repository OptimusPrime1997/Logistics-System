package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayRepStaffSalaryRepVO;
import VO.ReceiptVO.PayRepVO;
import VO.ReceiptVO.PayStaffSalaryVO;

public class Staffbl{
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO){
		payRepVO.staffSalary = payRepStaffSalaryRepVO;
	}
	
	public Vector<Object> initStaffTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayStaffSalaryVO> payStaffSalaryVOs = payRepVO.staffSalary.salaryVOs;
		if(payStaffSalaryVOs==null)
			return data;
		PayStaffSalaryVO payStaffSalaryVO;
		for(int i = 0;i < payStaffSalaryVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			payStaffSalaryVO = payStaffSalaryVOs.get(i);
			arr.add(payStaffSalaryVO.authority);
			arr.add(payStaffSalaryVO.getterName);
			arr.add(payStaffSalaryVO.getterNum);
			arr.add(payStaffSalaryVO.money);
			data.add(arr);
		}
		return data;
	}
}
