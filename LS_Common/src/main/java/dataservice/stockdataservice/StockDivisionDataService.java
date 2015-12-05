/**
 * 
 */
package dataservice.stockdataservice;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

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
	public ResultMessage update(InStockRepPO po) throws RemoteException;
	
	public ResultMessage update(OutStockRepPO po) throws RemoteException;
	
	/**
	 * 
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 */
	public ArrayList<StockDivisionPO> getStockDivision() throws RemoteException, IOException;
	
	
	
	
}
