package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.ReceiptVO;

public interface ReceiptblService extends PreReceiptblService{
	
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public void delete(int n) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public void delete(String num) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> T getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public void submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException, IOException;
	
	public <T extends ReceiptVO> ArrayList<T> getAllRep() throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> ArrayList<T> getRepBydate(String date) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
}
