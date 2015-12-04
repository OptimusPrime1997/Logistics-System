package bl.receiptbl.ReceptionRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.Rep;

public class ReceptionRepController extends ReceiptblController implements ReceptionRepblService{
	ReceptionRepbl receptionRep = new ReceptionRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		receptionRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		receptionRep.delete(num);
	}

	@Override
	public ArriveRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		receptionRep.submit(vo);
	}

	@Override
	public ArrayList<ArriveRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRep.getAllRep();
	}

	@Override
	public ArrayList<ArriveRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRep.getRepByDate(date);
	}

	@Override
	public String updateShip(Rep rep, String num) {
		// TODO Auto-generated method stub
		return receptionRep.updateShip(rep, num);
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return receptionRep.getShipmentRep(num);
	}

	@Override
	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return receptionRep.getTransferRep(num);
	}


}
