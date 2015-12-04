/**
 * 
 */
package dataimpl.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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

	
	@Override
	public ResultMessage update(InStockRepPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public ResultMessage update(OutStockRepPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public ArrayList<StockDivisionPO> getStockDivision() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
