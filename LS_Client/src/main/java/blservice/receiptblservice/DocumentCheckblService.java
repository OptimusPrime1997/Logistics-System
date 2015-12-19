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
	
	public void saveRep (ReceiptVO vo, Rep rep);
	
	public Vector<Object> initTable() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<CashRepVO> cashCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<DeliverRepVO> deliverCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;;
	
	public ArrayList<GetRepVO> getCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<InStockRepVO> inStockCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<OutStockRepVO> outStockCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public PayRepVO payCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<ReceptionRepVO> receptionCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<ShipmentRepVO> shipmentCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<ShippingRepVO> shippingCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
	public ArrayList<TransferRepVO> transferCheck() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
}
