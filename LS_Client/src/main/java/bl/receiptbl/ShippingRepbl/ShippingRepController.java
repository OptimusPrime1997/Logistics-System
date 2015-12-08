package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShippingRepblService;

public class ShippingRepController extends ReceiptblController implements ShippingRepblService{
	ShippingRepbl shippingRep = new ShippingRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shippingRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shippingRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shippingRep.delete(num);
	}

	@Override
	public ShippingRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shippingRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shippingRep.submit(vo);
	}

	@Override
	public ArrayList<ShippingRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shippingRep.getAllRep();
	}

	@Override
	public ArrayList<ShippingRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shippingRep.getRepByDate(date);
	}

	@Override
	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return shippingRep.getShippingRep(num);
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTruckNum(String date) {
		// TODO Auto-generated method stub
		return shippingRep.getTruckNum(date);
	}


}
