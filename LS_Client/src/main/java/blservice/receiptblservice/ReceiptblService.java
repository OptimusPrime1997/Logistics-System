package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import util.enumData.*;

public interface ReceiptblService{
	
	public String createNum(String date) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public ResultMessage delete(int n) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public ResultMessage delete(String num) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public ReceiptVO getRepByNum(String num) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public ResultMessage submit(ReceiptVO vo) throws RemoteException, MalformedURLException, NotBoundException, IOException;
	
	public ArrayList<CashRepVO> getAllRep() throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
	
	public ArrayList<CashRepVO> getRepBydate(String date) throws RemoteException, MalformedURLException, NotBoundException, ClassNotFoundException, IOException;
}
