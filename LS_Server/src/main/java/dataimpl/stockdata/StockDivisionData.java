/**
 * 
 */
package dataimpl.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;
import dataservice.stockdataservice.StockDivisionDataService;
import datautil.DataUtility;

/**
 * @author G
 *
 */
public class StockDivisionData extends UnicastRemoteObject implements StockDivisionDataService {

	String filename = "StockDivison.txt";
	DataUtility du = new DataUtility();
	/**
	 * @throws RemoteException
	 */
	public StockDivisionData() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResultMessage initial() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDivisionDataService#update(PO.InStockRepPO)
	 */
	@Override
	public void update(InStockRepPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDivisionDataService#update(PO.OutStockRepPO)
	 */
	@Override
	public void update(OutStockRepPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDivisionDataService#getStockDivision()
	 */
	@Override
	public ArrayList<StockDivisionPO> getStockDivision() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
