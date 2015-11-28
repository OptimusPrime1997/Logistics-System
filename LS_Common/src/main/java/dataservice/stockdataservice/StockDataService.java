/**
 * 
 */
package dataservice.stockdataservice;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.StockPO;


/**
 * @author G
 *
 */
public interface StockDataService {
	
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
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<StockPO> getStock() throws RemoteException, ClassNotFoundException, IOException;
	
	
	
	
	
}
