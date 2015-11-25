/**
 * 
 */
package dataimpl.stockdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	public ResultMessage delete(String listnum) throws RemoteException {
		//TODO读出来的是副本么？？需要再放回去么？

		ArrayList<StockPO> list = new ArrayList<StockPO>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Stock.txt"));
			while(ois.readBoolean()){
				StockPO po = (StockPO)ois.readObject();
				list.add(po);
			}
			for(StockPO po:list){
				if(po.getListNum().equals(listnum)) {
					list.remove(po);
				}
			}
		} catch (Exception e) {			
			e.printStackTrace();
			return ResultMessage.FAILED;
		}
		
		
		return ResultMessage.SUCCESS;
		
	}


	
	@Override
	public ArrayList<StockPO> getStock() throws RemoteException {
		
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Stock.txt"));
			while(ois.readBoolean()){
				StockPO po = (StockPO)ois.readObject();
				list.add(po);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	
	
	
	
	
	
	
	
}
