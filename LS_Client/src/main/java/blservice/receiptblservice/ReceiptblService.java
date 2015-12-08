package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import Exception.NameNotFoundException;
import Exception.NumNotFoundException;
import VO.ReceiptVO.ReceiptVO;
import util.enumData.ResultMessage;

public interface ReceiptblService extends PreReceiptblService{
	
	public String createNum(String date) throws NotBoundException, ClassNotFoundException, IOException;
	
	public void delete(int n) throws NotBoundException, ClassNotFoundException, IOException;
	
	public void delete(String num) throws NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> T getRepByNum(String num) throws NotBoundException, ClassNotFoundException, IOException;
	
	public void submit(ReceiptVO vo) throws NotBoundException, IOException;
	
	public <T extends ReceiptVO> ArrayList<T> getAllRep() throws NotBoundException, ClassNotFoundException, IOException;
	
	public <T extends ReceiptVO> ArrayList<T> getRepBydate(String date) throws NotBoundException, ClassNotFoundException, IOException;
	
	public Vector<Object> initCheck() throws ClassNotFoundException, NotBoundException, IOException, NameNotFoundException, NumNotFoundException;
	
	public Vector<Object> initShow(String num) throws ClassNotFoundException, NotBoundException, IOException;
	
}
