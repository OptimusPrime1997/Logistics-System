/**
 * 
 */
package dataservice.stockdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.City;
import util.enumData.ResultMessage;
import PO.StockPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;


/**
 * @author G
 *
 */
public interface StockDataService extends Remote{
	
	
	public ResultMessage update(InStockRepPO po) throws RemoteException;
	
	public ResultMessage update(OutStockRepPO po) throws RemoteException;
	
	/**
	 * add stockPO to stockData
	 * @param po
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ResultMessage add(StockPO po)throws RemoteException, ClassNotFoundException, IOException;
	
	/**
	 * delete by listnum
	 * @param listnum
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ResultMessage delete(String listnum)throws RemoteException, ClassNotFoundException, IOException;
	
	/**
	 * 得到当前城市仓库的货物
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<StockPO> getStock(City cityNum) throws RemoteException, ClassNotFoundException, IOException;
	
	
	
	
	
}
