package bl.receiptbl.ShipmentRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ShipmentRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PostReceiptblService;
import blservice.receiptblservice.ShipmentRepblServce;
import blservice.receiptblservice.SubmitblService;
import util.enumData.ResultMessage;

public class ShipmentRepController extends ReceiptblController 
implements ShipmentRepblServce, PostReceiptblService, SubmitblService {
	private ShipmentRepbl shipmentRepbl = new ShipmentRepbl();
	private ShipmentRepCheckbl shipmentRepCheckbl = new ShipmentRepCheckbl();
	private ShipmentRepShowbl shipmentRepShowbl = new ShipmentRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shipmentRepbl.createNum(date, office);
	}

	@Override
	public ShipmentRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return shipmentRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		shipmentRepbl.submit(vo);
	}

	@Override
	public ArrayList<ShipmentRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return shipmentRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<ShipmentRepVO> getRepByDate(String date, String office)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return shipmentRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return shipmentRepShowbl.initShow(num);
	}

	@Override
	public String getTruckSum(String date, String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return shipmentRepbl.getTruckSum(date, office);
	}

	@Override
	public boolean isTrueAccount(String num) {
		// TODO Auto-generated method stub
		return shipmentRepbl.isTrueAccount(num);
	}

	@Override
	public boolean isTrueOrder(String order) {
		// TODO Auto-generated method stub
		return shipmentRepbl.isTrueOrder(order);
	}

}
