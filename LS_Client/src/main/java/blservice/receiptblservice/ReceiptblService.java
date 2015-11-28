package blservice.receiptblservice;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import VO.CashRepVO;
import VO.ReceiptVO;
import util.enumData.*;

public interface ReceiptblService{
	
	public String createNum(String date);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
	
	public ReceiptVO getRepByNum(String num);
	
	public ResultMessage submit(CashRepVO vo) throws RemoteException, MalformedURLException, NotBoundException;
	
	public ArrayList<CashRepVO> getAllCashRep() throws RemoteException, MalformedURLException, NotBoundException;
	
	public ArrayList<CashRepVO> getRepBydate(String date) throws RemoteException, MalformedURLException, NotBoundException;
}
