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
import PO.StockDivisionPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;


/**
 * @author G
 *
 */
public interface StockDivisionDataService extends Remote{
	
	

	/**
	 * update stockData and stockDivisionData
	 * @param rep
	 * @throws RemoteException
	 */
	public ResultMessage update(InStockRepPO po, City cityNum) throws RemoteException;
	
	public ResultMessage update(OutStockRepPO po) throws RemoteException;
	
	public ResultMessage add (StockDivisionPO po); 
	
	public StockDivisionPO find (int block, int place) throws ClassNotFoundException, IOException;
	
	
	public ResultMessage delete (String listNum);
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 */
	public ArrayList<StockDivisionPO> getStockDivision(City cityNum) throws RemoteException, IOException;
	
	
	
	
}
