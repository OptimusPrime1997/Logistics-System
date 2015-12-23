package bl.receiptbl.PayRepbl;

import java.util.Vector;

import VO.Receipt.PayRepRentRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepRentblService;

public class PayRepRentController extends PayThingMethods implements PayRepRentblService{

	private Rentbl rentbl = new Rentbl();

	@Override
	public void submitRent(PayRepVO payRepVO, PayRepRentRepVO payRepRentRepVO) {
		// TODO Auto-generated method stub
		rentbl.submitRent(payRepVO, payRepRentRepVO);
	}

	@Override
	public Vector<Object> initRentTable(PayRepVO payRepVO) {
		// TODO Auto-generated method stub
		return rentbl.initRentTable(payRepVO);
	}

}
