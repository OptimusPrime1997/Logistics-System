package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.ManagementVO.DriverVO;
import VO.Receipt.PayDriverSalaryVO;
import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepVO;
import bl.managementbl.salarypolicybl.SalaryPolicybl;
import util.enumData.Authority;

public class Driverbl{
	
	private SalaryPolicybl salaryPolicybl = new SalaryPolicybl();
	private bl.managementbl.vehicleanddriverbl.Driverbl driverbl = new bl.managementbl.vehicleanddriverbl.Driverbl();
	
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO){
		payRepVO.driverSalary = payRepDriverSalaryRepVO;
	}
	
	public Vector<Object> initDriverSalaryTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException,
			NumNotFoundException{
		Vector<Object> data = new Vector<Object>();
		double moneyTime = salaryPolicybl.findByAuthority(Authority.DRIVER).value;
		ArrayList<DriverVO> driverVOs = driverbl.showDriver();
		for(DriverVO driverVO : driverVOs){
			Vector<String> arr = new Vector<String>();
			arr.add(driverVO.name);
			arr.add(driverVO.driverNum);
			arr.add(driverVO.number+"");
			arr.add(driverVO.number*moneyTime+"");
			data.add(arr);
		}
		return data;
	}
	
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO){
		Vector<Object> data = new Vector<Object>();
		PayRepDriverSalaryRepVO driverSalaryRepVO = payRepVO.driverSalary;
		if(driverSalaryRepVO==null)
			return data;
		ArrayList<PayDriverSalaryVO> payDriverSalaryVOs = driverSalaryRepVO.driverSalaryVOs;
		PayDriverSalaryVO payDriverSalaryVO;
		for(int i = 0;i < payDriverSalaryVOs.size();i++){
			Vector<String> arr = new Vector<String>();
			payDriverSalaryVO = payDriverSalaryVOs.get(i);
			arr.add(payDriverSalaryVO.getterName);
			arr.add(payDriverSalaryVO.getterNum);
			arr.add(payDriverSalaryVO.time+"");
			arr.add(payDriverSalaryVO.money+"");
			data.add(arr);
		}
		return data;
	}
}
