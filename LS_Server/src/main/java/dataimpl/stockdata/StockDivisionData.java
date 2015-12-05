/**
 * 
 */
package dataimpl.stockdata;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
	public ResultMessage update(InStockRepPO po) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		//TODO 得到本地城市
		String citynum = "Nanjing";
		ArrayList<InStockPO> list = po.getInStockPOs();
		System.out.println("----   "+list.size());
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			//TODO 由区号得到城市号，暂时只用了区号代替城市
			rm = add(new StockDivisionPO(inpo.getOrder(),citynum, block+"", block, place));
			System.out.println("re   :" +rm);
		}
		return rm;
		
	}

	
	/**
	 * @param stockDivisionPO
	 * @return
	 */
	private ResultMessage add(StockDivisionPO po) {		

		ArrayList<Object> list ;
		try {
			list = du.getAll(filename);
		
			if(list != null) {
				
				for(Object o:list){
					StockDivisionPO p = (StockDivisionPO)o;
					
					if(p.getBlock()==po.getBlock()&&p.getPlace()==po.getPlace()){
						return ResultMessage.EXIST;
					}
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
		ResultMessage rm = ResultMessage.SUCCESS;
		ArrayList<String> list = po.getGoods();
		for(String goods : list) {
			 rm = delete(goods);
			
		}
		return rm;
		
	}

	
	/**
	 * @param goods
	 * @return
	 */
	private ResultMessage delete(String goods) {
		boolean isFound = false;
		ArrayList<Object> list ;
		try {
			list = du.getAll(filename);
			if (list != null) {
				for(int i = 0;i < list.size();++i) {
					StockDivisionPO po = (StockDivisionPO)list.get(i);
					String s=po.getListNum();
					System.out.println(s);
					if(s.equals(goods)){
						isFound = true;
						list.remove(i);
					}
				}
			} else {
				return ResultMessage.NOT_FOUND;
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
