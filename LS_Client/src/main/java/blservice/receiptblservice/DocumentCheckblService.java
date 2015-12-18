package blservice.receiptblservice;

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
import util.enumData.Rep;

public interface DocumentCheckblService {
	
	public String saveRep (ReceiptVO vo, Rep rep);
	
	public Vector<Object> checkAllRep();
	
	public ArrayList<CashRepVO> cashCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<DeliverRepVO> deliverCheck();
	
	public ArrayList<GetRepVO> getCheck();
	
	public ArrayList<InStockRepVO> getInStock();
	
	public ArrayList<OutStockRepVO> getOutStock();
	
	public ArrayList<PayRepVO> getPay();
	
	public ArrayList<ReceptionRepVO> getReception();
	
	public ArrayList<ShipmentRepVO> getShipment();
	
	public ArrayList<ShippingRepVO> getShipping();
	
	public ArrayList<TransferRepVO> getTransfer();
}
