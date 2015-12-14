package bl.receiptbl.OutStockRepbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NumNotFoundException;
import VO.ReceiptVO.InStockRepVO;
import VO.ReceiptVO.OutStockRepVO;
import VO.ReceiptVO.ReceiptVO;
import VO.ReceiptVO.ShippingRepVO;
import VO.ReceiptVO.TransferRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import blservice.receiptblservice.OutStockRepblService;
import blservice.receiptblservice.PostReceiptblService;
import blservice.receiptblservice.SubmitblService;
import util.enumData.Rep;

public class OutStockRepController extends ReceiptblController 
implements OutStockRepblService, PostReceiptblService, SubmitblService{
	private OutStockRepbl outStackRepbl = new OutStockRepbl();
	private OutStockRepCheckbl outStockRepCheckbl = new OutStockRepCheckbl();
	private OutStockRepShowbl outStockRepShowbl = new OutStockRepShowbl();

	@Override
	public String createNum(String date, String office)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.createNum(date, office);
	}

	@Override
	public OutStockRepVO getRepByNum(String num)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, 
			IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return outStockRepCheckbl.getRepByNum(num);
	}

	@Override
	public void submit(ReceiptVO vo) 
			throws RemoteException, MalformedURLException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		outStackRepbl.submit(vo);
	}

	@Override
	public ArrayList<OutStockRepVO> getAllRep(String office)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, 
			IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.getAllRep(office);
	}

	@Override
	public ArrayList<OutStockRepVO> getRepByDate(String date, String office)
			throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException,
			IOException {
		// TODO Auto-generated method stub
		return outStackRepbl.getRepByDate(date, office);
	}

	@Override
	public Vector<Object> initCheck(String office) 
			throws ClassNotFoundException, NotBoundException, IOException {
		// TODO Auto-generated method stub
		return outStockRepCheckbl.initCheck(office);
	}

	@Override
	public Vector<Object> initShow(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return outStockRepShowbl.initShow(num);
	}

	@Override
	public ShippingRepVO getShippingRepVO(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return outStackRepbl.getShippingRepVO(num);
	}

	@Override
	public TransferRepVO getTransferRepVO(String num)
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException {
		// TODO Auto-generated method stub
		return outStackRepbl.getTransferRepVO(num);
	}

	@Override
	public ArrayList<OutStockRepVO> getAllRepByDate(String date)
			throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, NotBoundException {
		// TODO Auto-generated method stub
		return outStackRepbl.getAllRepByDate(date);
	}

}
