package bl.receiptbl.PayRepbl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import Exception.NumNotFoundException;
import Exception.SalaryPolicyNotFoundException;
import VO.Receipt.PayRepDriverSalaryRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepDriverblService;

public class PayRepDriverController extends PayThingMethods implements PayRepDriverblService{
	
	private Driverbl driverbl = new Driverbl();

	@Override
	public void submitDriver(PayRepVO payRepVO, PayRepDriverSalaryRepVO payRepDriverSalaryRepVO) {
		// TODO Auto-generated method stub
		driverbl.submitDriver(payRepVO, payRepDriverSalaryRepVO);
	}

	@Override
	public Vector<Object> initDriverSalaryTable()
			throws FileNotFoundException, ClassNotFoundException, SalaryPolicyNotFoundException, IOException,
			NumNotFoundException {
		// TODO Auto-generated method stub
		return driverbl.initDriverSalaryTable();
	}

	@Override
	public Vector<Object> initDriverSalaryTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return driverbl.initDriverSalaryTable(payRepVO);
	}

}
