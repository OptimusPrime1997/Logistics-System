/**
 * 
 */
package dataimpl.stockdata;


import java.io.File;
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
import dataservice.stockdataservice.StockInitialDataService;
import datautil.DataUtility;

/**
 * @author G
 *
 */
public class StockData extends UnicastRemoteObject implements StockDataService{

	String filename = "Stock.txt";
	DataUtility du = new DataUtility();
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


	/**
	 * 在文件末尾增添序列化库存po
	 */
	@Override
	public ResultMessage add(StockPO po) throws RemoteException {
		ArrayList<Object> list;
		ResultMessage rm;
		try {
			list = du.getAll(filename);
			
			for(Object o:list){
				StockPO p = (StockPO)o;
				if(p.getListNum().equals(po.getListNum())){
					return ResultMessage.EXIST;
				}
			}
			
			return rm = du.save(po, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILED;
	}


	@Override
	public ResultMessage delete(String listnum) throws RemoteException {
		boolean isFound = false;
		ArrayList<Object> list;
		try {
			list = du.getAll(filename);
			
			for(int i = 0;i < list.size();++i) {
				StockPO po = (StockPO)list.get(i);
				if(po.getListNum().equals(listnum)){
					isFound = true;
					list.remove(i);
				}
			}
			
			du.SaveAll(list, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		if(!isFound){
			return ResultMessage.NOT_FOUND;
		}else{
			return ResultMessage.SUCCESS;
		}
		
	}


	
	@Override
	public ArrayList<StockPO> getStock() throws IOException {
		
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		ArrayList<Object> listo;
		try {
			listo = du.getAll(filename);
			
			for(Object o:listo) {
				StockPO po = (StockPO) o;
				list.add(po);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	
	
	
	
	
}
