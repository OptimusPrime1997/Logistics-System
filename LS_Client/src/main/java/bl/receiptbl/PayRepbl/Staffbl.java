package bl.receiptbl.PayRepbl;

import java.util.Vector;

import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;

public class Staffbl{
	
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO){
		payRepVO.staffSalary = payRepStaffSalaryRepVO;
	}
	
	public Vector<Object> initStaffTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		
		return data;
	}
}
