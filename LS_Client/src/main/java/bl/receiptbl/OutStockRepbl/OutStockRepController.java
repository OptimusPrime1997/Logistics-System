package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.OutStockRepVO;
import VO.ReceiptVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.OutStockRepblService;

public class OutStockRepController extends ReceiptblController implements OutStockRepblService{
<<<<<<< HEAD
	OutStackRepbl outStackRepbl = new OutStackRepbl();
=======
	OutStockRepbl OutStackRepbl = new OutStockRepbl();
>>>>>>> origin/master

	@Override
	public String createNum(String date)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.createNum(date);
	}

	@Override
	public void delete(int n)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		outStackRepbl.delete(n);
	}

	@Override
	public void delete(String num)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		outStackRepbl.delete(num);
	}

	@Override
	public OutStockRepVO getRepByNum(String num)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		outStackRepbl.submit(vo);
	}

	@Override
	public ArrayList<OutStockRepVO> getAllRep()
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.getAllRep();
	}

	@Override
	public ArrayList<OutStockRepVO> getRepBydate(String date)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.getRepByDate(date);
	}


}
