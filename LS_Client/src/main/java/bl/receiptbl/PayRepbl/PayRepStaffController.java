package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepStaffSalaryRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepStaffblService;

public class PayRepStaffController extends PayThingMethods implements PayRepStaffblService{
	
	private Staffbl staffbl = new Staffbl();

	@Override
	public void submitStaff(PayRepVO payRepVO, PayRepStaffSalaryRepVO payRepStaffSalaryRepVO) {
		// TODO Auto-generated method stub
		staffbl.submitStaff(payRepVO, payRepStaffSalaryRepVO);
	}

	@Override
	public Vector<Object> initStaffTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException,
			NumNotFoundException {
		// TODO Auto-generated method stub
		return staffbl.initStaffTable();
	}

	@Override
	public Vector<Object> initStaffTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return staffbl.initStaffTable(payRepVO);
	}

}
