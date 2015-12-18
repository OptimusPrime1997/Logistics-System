package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.NumNotFoundException;
import VO.Receipt.OutStockRepVO;
import VO.Receipt.ShippingRepVO;
import VO.Receipt.TransferRepVO;

public interface OutStockRepblService extends ReceiptblService{
	
	public ShippingRepVO getShippingRepVO(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public TransferRepVO getTransferRepVO(String num) throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public ArrayList<OutStockRepVO> getAllRepByDate(String date) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, NotBoundException;
}
