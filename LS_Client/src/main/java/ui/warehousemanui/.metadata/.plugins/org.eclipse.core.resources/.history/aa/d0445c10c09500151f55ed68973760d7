/**
 * 
 */
package dataimpl.stockdata;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.StockNumPO;
import PO.StockPO;
import dataservice.stockdataservice.StockInitialDataService;

/**
 * @author G
 *
 */
public class StockInitialData implements StockInitialDataService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 初始化库存数量
	 */
	@Override
	public ResultMessage initial(StockNumPO po) throws RemoteException {
		try {
			FileOutputStream fos = new FileOutputStream("StockNum.txt");
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

	/**
	 * 得到库存初始化的值
	 */
	@Override
	public StockNumPO getInitialNum(String citynum) throws RemoteException {
	
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StockNum.txt"));
			while(ois.readBoolean()){
				StockNumPO po = (StockNumPO)ois.readObject();
				if(po.getCityNum().equals(citynum)){
					return po;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
