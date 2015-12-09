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
	
	private TransferRepbl transferRepbl = new TransferRepbl();
	private TransferRepCheckbl transferRepCheckbl = new TransferRepCheckbl();
	private TransferRepShowbl transferRepShowbl = new TransferRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.createNum(date);
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
	public TransferRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		transferRepbl.submit(vo);
	}

	@Override
	public ArrayList<TransferRepVO> getAllRep() 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getAllRep();
	}

	@Override
	public ArrayList<TransferRepVO> getRepByDate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepShowbl.initShow(num);
	}


}
