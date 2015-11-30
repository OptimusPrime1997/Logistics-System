package bl.receiptbl.ShipmentRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ReceiptVO;
import VO.ShipmentRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ShipmentRepblServce;

public class ShipmentController extends ReceiptblController implements ShipmentRepblServce{
	ShipmentRepbl shipmentRep = new ShipmentRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shipmentRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shipmentRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shipmentRep.delete(num);
	}

	@Override
	public ShipmentRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shipmentRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		shipmentRep.submit(vo);
	}

	@Override
	public ArrayList<ShipmentRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shipmentRep.getAllRep();
	}

	@Override
	public ArrayList<ShipmentRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return shipmentRep.getRepByDate(date);
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return shipmentRep.getShipmentRep(num);
	}

}
