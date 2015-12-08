package bl.receiptbl.InStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.InStockRepblService;

public class InStockRepController extends ReceiptblController implements InStockRepblService{
	private InStockRepbl inStockRepbl = new InStockRepbl();
	private InStockRepCheckbl inStockRepCheckbl = new InStockRepCheckbl();
	private InStockRepShowbl inStockRepShowbl = new InStockRepShowbl();

	@Override
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.createNum(date);
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
	public InStockRepVO getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		inStockRepbl.submit(vo);
	}

	@Override
	public ArrayList<InStockRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InStockRepVO> getRepByDate(String date)
			throws NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepbl.getRepByDate(date);
	}

	@Override
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepCheckbl.initCheck();
	}

	@Override
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return inStockRepShowbl.initShow(num);
	}

}
