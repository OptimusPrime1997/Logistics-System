package bl.receiptbl.DeliverRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ReceiptVO.DeliverRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.DeliverRepblService;

public class DeliverController extends ReceiptblController implements DeliverRepblService{
	DeliverRepbl deliverRep = new DeliverRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return deliverRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		deliverRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 deliverRep.delete(num);
	}

	@Override
	public DeliverRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 return deliverRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 deliverRep.submit(vo);
	}

	@Override
	public ArrayList<DeliverRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return deliverRep.getAllRep();
	}

	@Override
	public ArrayList<DeliverRepVO> getRepBydate(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return deliverRep.getRepByDate(date);
	}

}
