/**
 * 
 */
package dataimpl.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import PO.StockDivisionPO;
import PO.StockPO;
import dataservice.stockdataservice.StockDataService;

/**
 * @author G
 *
 */
public class StockData extends UnicastRemoteObject implements StockDataService{

	
	/**
	 * @throws RemoteException
	 */
	public StockData() throws RemoteException {
		super();
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public void add(StockPO po) throws RemoteException {
		
		
	}

	
	@Override
	public void initial(int initialNum) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public int getPresentQuantity() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public ArrayList<StockPO> show() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String findInStockNumByDivision(StockDivisionPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
