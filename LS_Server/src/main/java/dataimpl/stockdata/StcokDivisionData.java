/**
 * 
 */
package dataimpl.stockdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.InStockRepPO;
import PO.OutStockRepPO;
import PO.StockDivisionPO;
import dataservice.stockdataservice.StockDivisionDataService;

/**
 * @author G
 *
 */
public class StcokDivisionData extends UnicastRemoteObject implements StockDivisionDataService {

	/**
	 * @throws RemoteException
	 */
	protected StcokDivisionData() throws RemoteException {
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
