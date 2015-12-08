package bl.receiptbl.ReceptionRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ArriveRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShipmentRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.ReceptionRepblService;
import util.enumData.Rep;

public class ReceptionRepController extends ReceiptblController implements ReceptionRepblService{
	private ReceptionRepbl receptionRepbl = new ReceptionRepbl();
	private ReceptionRepCheckbl receptionRepCheckbl = new ReceptionRepCheckbl();
	private ReceptionRepShowbl receptionRepShowbl = new ReceptionRepShowbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRepbl.createNum(date);
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
	public ArriveRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		receptionRepbl.submit(vo);
	}

	@Override
	public ArrayList<ArriveRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return receptionRepbl.getAllRep();
	}

	@Override
	public ArrayList<ArriveRepVO> getRepByDate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipmentRepVO getShipmentRep(String num) {
		// TODO Auto-generated method stub
		return receptionRepbl.getShipmentRep(num);
	}

	@Override
	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return receptionRepbl.getTransferRep(num);
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return receptionRepShowbl.initShow(num);
	}


}
