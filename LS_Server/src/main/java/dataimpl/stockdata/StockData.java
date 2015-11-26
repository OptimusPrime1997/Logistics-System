/**
 * 
 */
package dataimpl.stockdata;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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


	/**
	 * 以追加的方式增添序列化库存po
	 */
	@Override
	public ResultMessage add(StockPO po) throws RemoteException {
	
		File file=new File("Stock.txt");
		try{
        if(file.exists()){ 
               boolean isexist=true;
               FileOutputStream fo=new FileOutputStream(file,true);
               ObjectOutputStream oos = new ObjectOutputStream(fo);
               long pos=0;
              if(isexist){
                        pos=fo.getChannel().position()-4;
                        fo.getChannel().truncate(pos);
                           }
                oos.writeObject(po);
                oos.close();
          }else{//文件不存在
                 file.createNewFile();
             FileOutputStream fo=new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
             oos.writeObject(po);
             oos.close();
          }
		}catch(Exception e) {
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
