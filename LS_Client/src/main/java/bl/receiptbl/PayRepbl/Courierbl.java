package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayCourierSalaryVO;
import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepVO;
import bl.managementbl.salarypolicybl.SalaryPolicybl;
import util.enumData.Authority;

public class Courierbl{
	
	private SalaryPolicybl salaryPolicybl = new SalaryPolicybl();
	
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO){
		payRepVO.courierSalary = payRepCourierSalaryRepVO;
	}
	
	public Vector<Object> initCourierSalaryTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, 
			IOException, NumNotFoundException{
		Vector<Object> data = new Vector<Object>();
		double moneyPercentage = salaryPolicybl.findByAuthority(Authority.COURIER).value;
		
		return data;
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
			arr.add(payCourierSalaryVO.deliverMoneySum+"");
			arr.add(payCourierSalaryVO.money+"");
			data.add(arr);
		}
		return data;
	}
}
