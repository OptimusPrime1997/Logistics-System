package bl.receiptbl.DocumentCheckbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import VO.Receipt.CashRepVO;
import VO.Receipt.DeliverRepVO;
import VO.Receipt.GetRepVO;
import VO.Receipt.InStockRepVO;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.PayRepVO;
import VO.Receipt.ReceiptVO;
import VO.Receipt.ReceptionRepVO;
import VO.Receipt.ShipmentRepVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;
import blservice.receiptblservice.DocumentCheckblService;
import util.enumData.Rep;

public class DocumentCheckController implements DocumentCheckblService{
	DocumentCheckbl documentCheckbl = new DocumentCheckbl();

	@Override
	public void saveRep(ReceiptVO vo, Rep rep) {
		// TODO Auto-generated method stub
	}

	@Override
	public Vector<Object> initTable() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.initTable();
	}

	@Override
	public ArrayList<CashRepVO> cashCheck() 
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, 
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.cashCheck();
	}

	@Override
	public ArrayList<DeliverRepVO> deliverCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.deliverCheck();
	}

	@Override
	public ArrayList<GetRepVO> getCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.getCheck();
	}

	@Override
	public ArrayList<InStockRepVO> inStockCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.inStockCheck();
	}

	@Override
	public ArrayList<OutStockRepVO> outStockCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.outStockCheck();
	}

	@Override
	public PayRepVO payCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.payCheck();
	}

	@Override
	public ArrayList<ReceptionRepVO> receptionCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.receptionCheck();
	}

	@Override
	public ArrayList<ShipmentRepVO> shipmentCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.shipmentCheck();
	}

	@Override
	public ArrayList<ShippingRepVO> shippingCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.shippingCheck();
	}

	@Override
	public ArrayList<TransferRepVO> transferCheck()  
			throws ClassNotFoundException, RemoteException, MalformedURLException, IOException,
			NotBoundException {
		// TODO Auto-generated method stub
		return documentCheckbl.transferCheck();
	}

}
