package blservice.receiptblservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Exception.GoodsNotFound;
import VO.StockDivisionVO;
import VO.ReceiptVO.InStockRepVO;
import util.enumData.City;
import util.enumData.ResultMessage;

public interface InStockRepblService extends ReceiptblService{
	public String getCity(String order) throws GoodsNotFound;
	
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException;
	
	public ResultMessage delete(String listNum) throws RemoteException, MalformedURLException, NotBoundException;
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException;
}
