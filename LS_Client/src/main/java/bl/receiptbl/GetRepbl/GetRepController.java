package bl.receiptbl.GetRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.CashRepVO;
import VO.GetRepVO;
import VO.ReceiptVO;
import VO.ShipmentRepVO;
import VO.ShippingRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.GetRepblService;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public class GetRepController extends ReceiptblController implements GetRepblService{
	GetRepbl getRep = new GetRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 getRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 getRep.delete(num);
	}

	@Override
	public GetRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		getRep.submit(vo);
	}

	@Override
	public ArrayList<GetRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getRep.getAllRep();
	}

	@Override
	public ArrayList<GetRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return getRep.getRepByDate(date);
	}

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return getRep.updateShip(rep, num);
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return getRep.getShipmentRep(num);
	}

	@Override
	public ShippingRepVO getShippingRep(String num) {
		// TODO Auto-generated method stub
		return getRep.getShippingRep(num);
	}


}
