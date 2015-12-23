package bl.receiptbl.PayRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

import VO.Receipt.PayRepFreightRepVO;
import VO.Receipt.PayRepVO;
import blservice.receiptblservice.PayRepFreightblService;

public class PayRepFreightController extends PayThingMethods implements PayRepFreightblService{
	
	private Freightbl freightbl = new Freightbl();

	@Override
	public void submitFreight(PayRepVO payRepVO, PayRepFreightRepVO payRepFreightRepVO) {
		// TODO Auto-generated method stub
		freightbl.submitFreight(payRepVO, payRepFreightRepVO);
	}

	@Override
	public Vector<Object> initFreightTable(String date)
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		return freightbl.initFreightTable(date);
	}

	@Override
	public Vector<Object> initFreightTable(PayRepVO payRepVO){
		// TODO Auto-generated method stub
		return freightbl.initFreightTable(payRepVO);
	}

}
