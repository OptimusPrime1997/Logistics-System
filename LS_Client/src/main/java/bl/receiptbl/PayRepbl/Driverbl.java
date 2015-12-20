package bl.receiptbl.PayRepbl;

import java.util.Vector;

import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepVO;

public class Driverbl{
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO){
		payRepVO.driverSalary = payRepDriverSalaryRepVO;
	}
	
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		
		return data;
	}
}
