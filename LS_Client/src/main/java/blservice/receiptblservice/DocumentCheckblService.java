package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;
import VO.Receipt.ReceiptVO;
import util.enumData.Rep;

public interface DocumentCheckblService {
	
	public void saveRep (ReceiptVO vo, Rep rep);
	
	public Vector<Object> initTable() throws ClassNotFoundException, RemoteException, MalformedURLException, IOException, NotBoundException;
	
}
