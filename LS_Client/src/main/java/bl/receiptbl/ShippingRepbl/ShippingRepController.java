package bl.receiptbl.ShippingRepbl;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShippingRepblService;

public class ShippingRepController extends ReceiptblController implements ShippingRepblService {
	
	private ShippingRepbl shippingRepbl = new ShippingRepbl();
	private ShippingRepCheckbl shippingRepCheckbl = new ShippingRepCheckbl();
	private ShippingRepShowbl shippingRepShowbl = new ShippingRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepbl.createNum(date, office);
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
	public ArrayList<ShippingRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<ShippingRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepbl.getRepByDate(date, office);
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return shippingRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return shippingRepShowbl.initShow(num);
	}

	@Override
	public boolean isTrueAccount(String num) {
		// TODO Auto-generated method stub
		return shippingRepbl.isTrueAccount(num);
	}

	@Override
	public boolean isTrueOrder(String order) {
		// TODO Auto-generated method stub
		return shippingRepbl.isTrueOrder(order);
	}

}
