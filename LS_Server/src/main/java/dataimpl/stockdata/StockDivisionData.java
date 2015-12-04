/**
 * 
 */
package dataimpl.stockdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import PO.StockPO;
import PO.ReceiptPO.InStockPO;
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
		ResultMessage rm = ResultMessage.SUCCESS;
		//TODO 得到本地城市
		String citynum = "Nanjing";
		ArrayList<InStockPO> list = po.getInStockPOs();
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			//TODO 由区号得到城市号，暂时只用了区号代替城市
			rm = add(new StockDivisionPO(citynum, block+"", block, place));
			if(!rm.equals(ResultMessage.SUCCESS)) {
				return ResultMessage.FAILED;
			}
		}
		return rm;
		
	}

	
	/**
	 * @param stockDivisionPO
	 * @return
	 */
	private ResultMessage add(StockDivisionPO po) {
		// TODO 返回值还没完成
		

		ArrayList<Object> list;
		try {
			list = du.getAll(filename);
			
			for(Object o:list){
				StockDivisionPO p = (StockDivisionPO)o;
				
				if(p.getBlock()==po.getBlock()&&p.getPlace()==po.getPlace()){
					return ResultMessage.EXIST;
				}
			}
			
			return du.save(po, filename);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return ResultMessage.FAILED;
	}


	@Override
	public ResultMessage update(OutStockRepPO po) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public ArrayList<StockDivisionPO> getStockDivision() throws IOException {
	 
		ArrayList<StockDivisionPO> list = new ArrayList<StockDivisionPO>();
		ArrayList<Object> listo;
		try {
			listo = du.getAll(filename);
			
			for(Object o:listo) {
				StockDivisionPO po = (StockDivisionPO) o;
				list.add(po);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}
