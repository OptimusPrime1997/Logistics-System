package bl.receiptbl.PayRepbl;

import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.PayCourierSalaryVO;
import VO.ReceiptVO.PayRepCourierSalaryRepVO;
import VO.ReceiptVO.PayRepVO;

public class Courierbl{
	
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO){
		payRepVO.courierSalary = payRepCourierSalaryRepVO;
	}
	
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		ArrayList<PayCourierSalaryVO> payCourierSalaryVOs = payRepVO.courierSalary.courierSalaryVOs;
		if(payCourierSalaryVOs==null)
			return data;
		PayCourierSalaryVO payCourierSalaryVO;
		for(int i = 0;i < payCourierSalaryVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payCourierSalaryVO = payCourierSalaryVOs.get(i);
			arr.add(payCourierSalaryVO.getterName);
			arr.add(payCourierSalaryVO.getterNum);
			arr.add(payCourierSalaryVO.getMoneySum+"");
			arr.add(payCourierSalaryVO.deliverItemNum+"");
			arr.add(payCourierSalaryVO.money+"");
			data.add(arr);
		}
		return data;
	}
}
