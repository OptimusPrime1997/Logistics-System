package bl.receiptbl.InStockRepbl;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ReceiptVO.CashVO;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.InStockRepblService;
import util.enumData.ResultMessage;

public class InStockRepController extends ReceiptblController implements InStockRepblService{
	InStockRepbl inStockRep = new InStockRepbl();

	@Override
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return inStockRep.createNum(date);
	}

	@Override
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 inStockRep.delete(n);
	}

	@Override
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		 inStockRep.delete(num);
	}

	@Override
	public InStockRepVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return inStockRep.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		inStockRep.submit(vo);
	}

	@Override
	public ArrayList<InStockRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<InStockRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getTwoPosition(String destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
