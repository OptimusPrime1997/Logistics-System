 /**
 * 
 */
package dataimpl.stockdata;



import java.io.IOException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import PO.StockPO;
import PO.ReceiptPO.InStockPO;
import PO.ReceiptPO.InStockRepPO;
import PO.ReceiptPO.OutStockRepPO;
import dataservice.stockdataservice.StockDataService;

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
		try {
			list = du.getAll(filename);
			if (list != null){
				for(Object o:list){
					StockPO p = (StockPO)o;
					if(p.getListNum().equals(po.getListNum())){
						return ResultMessage.EXIST;
					}else if(p.getBlock()==po.getBlock()&&p.getPlace()==po.getPlace()){
						return ResultMessage.NOT_AVAILABLE;
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
	public ResultMessage delete(String listnum) throws RemoteException {
		boolean isFound = false;
		ArrayList<Object> list;
		try {
			list = du.getAll(filename);
			if (list != null) {
				for(int i = 0;i < list.size();++i) {
					StockPO po = (StockPO)list.get(i);

					if(po.getListNum().equals(listnum)){
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
	public ArrayList<StockPO> getStock() throws IOException {
		
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		ArrayList<Object> listo;
		try {
			
			
			listo = du.getAll(filename);
			if (listo != null) {
				for(Object o:listo) {
					StockPO po = (StockPO) o;
					list.add(po);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return list;
	}


	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDataService#update(PO.ReceiptPO.InStockRepPO)
	 */
	@Override
	public ResultMessage update(InStockRepPO po) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		String inrepnum = po.getNum();
		String date = po.getDate();
		//TODO 得到本地城市
		String citynum = "Nanjing";
		ArrayList<InStockPO> list = po.getInStockPOs();
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			// TODO 由区号得到城市
			
			rm = add(new StockPO(citynum, inpo.getOrder(), inrepnum, date, inpo.getArea(), block, place));

		}
		return rm;
	}


	/* (non-Javadoc)
	 * @see dataservice.stockdataservice.StockDataService#update(PO.ReceiptPO.OutStockRepPO)
	 */
	@Override
	public ResultMessage update(OutStockRepPO po) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		ArrayList<String> list = po.getGoods();
		for(String goods : list) {
			 rm = delete(goods);
			
		}
		return rm;
	}
	
	
	
	public static void main(String[] args) {

		try {

		StockData s = new StockData();

		ArrayList<InStockPO> list = new ArrayList<InStockPO>();

		list.add(new InStockPO("11", "6", "33"));

		list.add(new InStockPO("121", "6", "36"));

		ResultMessage r = s.update(new InStockRepPO("123", "11-01", list));

		s.update(new InStockRepPO("13", "11-01", new ArrayList<InStockPO>()));
	
		s.delete("111");
		System.out.println(s.getStock().size());

		System.out.println(r);
		
		System.out.println(s.getStock().get(3).getPlace());

		} catch (Exception e) {

		e.printStackTrace();

		}

		System.out.println();

		}
	
	
	
}
