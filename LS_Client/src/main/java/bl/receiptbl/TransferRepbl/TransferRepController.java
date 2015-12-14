package bl.receiptbl.TransferRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.PostReceiptblService;
import blservice.receiptblservice.SubmitblService;
import blservice.receiptblservice.TransferRepblService;

public class TransferRepController extends ReceiptblController
implements TransferRepblService, PostReceiptblService, SubmitblService{
	
	private TransferRepbl transferRepbl = new TransferRepbl();
	private TransferRepCheckbl transferRepCheckbl = new TransferRepCheckbl();
	private TransferRepShowbl transferRepShowbl = new TransferRepShowbl();

	@Override
	public String createNum(String date, String office) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.createNum(date, office);
	}

	@Override
	public TransferRepVO getRepByNum(String num) 
			throws NotBoundException, ClassNotFoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return transferRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		transferRepbl.submit(vo);
	}

	@Override
	public ArrayList<TransferRepVO> getAllRep(String office) 
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<TransferRepVO> getRepByDate(String date, String office)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepbl.getRepByDate(date, office);
	}

	@Override
	public Vector<Object> initCheck(String office) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return transferRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return transferRepShowbl.initShow(num);
	}

}
