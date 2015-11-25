/**
 * 
 */
package dataimpl.stockdata;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
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
	public ResultMessage add(StockPO po) throws RemoteException {
		try {
			FileOutputStream fos = new FileOutputStream("Stock.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(po);
			oos.flush();
			oos.close();
						
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		return ResultMessage.SUCCESS;
		
	}


	
	@Override
	public ResultMessage delete(int listnum) throws RemoteException {
		//TODO
		
		return ResultMessage.SUCCESS;
		
	}


	
	@Override
	public ArrayList<StockPO> getStock() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
}
