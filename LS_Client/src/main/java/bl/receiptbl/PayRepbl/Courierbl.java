package bl.receiptbl.PayRepbl;

import java.util.Vector;

import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepVO;

public class Courierbl{
	
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO){
		payRepVO.courierSalary = payRepCourierSalaryRepVO;
	}
	
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		
		return data;
	}
}
