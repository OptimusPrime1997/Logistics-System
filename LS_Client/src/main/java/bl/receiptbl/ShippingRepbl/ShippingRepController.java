package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShippingRepblService;

public class ShippingRepController extends ReceiptblController implements ShippingRepblService{
	
	private ShippingRepbl shippingRepbl = new ShippingRepbl();
	private ShippingRepCheckbl shippingRepCheckbl = new ShippingRepCheckbl();
	private ShippingRepShowbl shippingRepShowbl = new ShippingRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepbl.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public ShippingRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return shippingRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		shippingRepbl.submit(vo);
	}

	@Override
	public ArrayList<ShippingRepVO> getAllRep() 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepbl.getAllRep();
	}

	@Override
	public ArrayList<ShippingRepVO> getRepByDate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return shippingRepShowbl.initShow(num);
	}

	@Override
	public int getSumByTrsOfficeNum(String str, String date) {
		// TODO Auto-generated method stub
		return 39;
	}


}
