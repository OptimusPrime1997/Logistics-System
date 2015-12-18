package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Exception.GoodsNotFound;
import VO.StockDivisionVO;
import VO.Receipt.InStockRepVO;
import util.enumData.City;
import util.enumData.ResultMessage;

public interface InStockRepblService extends ReceiptblService{
	public String getCity(String order) throws GoodsNotFound;
	
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException;
	
	public ResultMessage delete(String listNum) throws RemoteException, MalformedURLException, NotBoundException;
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException;
	
	public ArrayList<InStockRepVO> getAllRepByDate(String date) throws ClassNotFoundException, MalformedURLException, RemoteException, IOException, NotBoundException;
}
