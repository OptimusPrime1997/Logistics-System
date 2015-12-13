package blservice.receiptblservice;

import java.io.IOException;
import java.rmi.NotBoundException;

import Exception.NumNotFoundException;
import VO.ReceiptVO.ShippingRepVO;
import VO.ReceiptVO.TransferRepVO;

public interface OutStockRepblService extends ReceiptblService{
	
	public ShippingRepVO getShippingRepVO(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
	
	public TransferRepVO getTransferRepVO(String num) 
			throws ClassNotFoundException, NotBoundException, IOException, NumNotFoundException;
}
