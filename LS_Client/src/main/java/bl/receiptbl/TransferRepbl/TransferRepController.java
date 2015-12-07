package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.TransferRepblService;

public class TransferRepController extends ReceiptblController implements TransferRepblService{
	TransferRepbl transferRep = new TransferRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return transferRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		transferRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		transferRep.delete(num);
	}

	@Override
	public TransferRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return transferRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		transferRep.submit(vo);
	}

	@Override
	public ArrayList<TransferRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return transferRep.getAllRep();
	}

	@Override
	public ArrayList<TransferRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return transferRep.getRepByDate(date);
	}

	@Override
	public TransferRepVO getTransferRep(String num) {
		// TODO Auto-generated method stub
		return transferRep.getTransferRep(num);
	}

	@Override
	public Vector<Object> checkAll() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}


}
