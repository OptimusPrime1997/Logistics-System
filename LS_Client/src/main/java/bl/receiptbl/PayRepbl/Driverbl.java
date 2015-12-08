package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayDriverSalaryVO;
import VO.ReceiptVO.PayRepDriverSalaryRepVO;
import VO.ReceiptVO.PayRepVO;

public class Driverbl{
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO){
		payRepVO.driverSalary = payRepDriverSalaryRepVO;
	}
	
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayDriverSalaryVO> payDriverSalaryVOs = payRepVO.driverSalary.driverSalaryVOs;
		if(payDriverSalaryVOs==null)
			return data;
		PayDriverSalaryVO payDriverSalaryVO;
		for(int i = 0;i < payDriverSalaryVOs.size();i++){
			Vector<Object> arr = new Vector<Object>();
			payDriverSalaryVO = payDriverSalaryVOs.get(i);
			arr.add(payDriverSalaryVO.getterName);
			arr.add(payDriverSalaryVO.getterNum);
			arr.add(payDriverSalaryVO.time);
			arr.add(payDriverSalaryVO.money);
			data.add(arr);
		}
		return data;
	}
}
