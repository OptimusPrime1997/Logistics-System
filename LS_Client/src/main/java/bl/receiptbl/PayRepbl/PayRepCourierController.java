package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepCourierSalaryRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepCourierblService;

public class PayRepCourierController extends PayThingMethods implements PayRepCourierblService{
	
	private Courierbl courierbl = new Courierbl();

	@Override
	public void submitCourier(PayRepVO payRepVO, PayRepCourierSalaryRepVO payRepCourierSalaryRepVO) {
		// TODO Auto-generated method stub
		courierbl.submitCourier(payRepVO, payRepCourierSalaryRepVO);
	}

	@Override
	public Vector<Object> initCourierSalaryTable() 
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException,
			NumNotFoundException {
		// TODO Auto-generated method stub
		return courierbl.initCourierSalaryTable();
	}

	@Override
	public Vector<Object> initCourierSalaryTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return courierbl.initCourierSalaryTable(payRepVO);
	}

}
