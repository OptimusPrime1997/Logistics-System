 /**
 * 
 */
package dataimpl.stockdata;



import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import util.FromIntToCity;
import util.enumData.City;
import util.enumData.ResultMessage;
import PO.StockPO;
import PO.Receipt.InStockPO;
import PO.Receipt.InStockRepPO;
import PO.Receipt.OutStockRepPO;
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
	public ArrayList<StockPO> getStock(City cityNum) throws IOException {
		
		ArrayList<StockPO> list = new ArrayList<StockPO>();
		ArrayList<Object> listo;
		try {
			
			
			listo = du.getAll(filename);
			if (listo != null) {
				for(Object o:listo) {
					StockPO po = (StockPO) o;
					if (po.getCityNum().equals(cityNum)){
						list.add(po);
					}
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
	public ResultMessage update(InStockRepPO po, City cityNum) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
		String inrepnum = po.getNum();
		String date = po.getDate();
			
		ArrayList<InStockPO> list = po.getInStockPOs();
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			City desCity = FromIntToCity.toCity(block);
			rm = add(new StockPO(cityNum, inpo.getOrder(), inrepnum, date, desCity, block, place));

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
		StockPO p1 = new StockPO(City.NANJING, "0000000000001", "00010000000110", "01-02", City.BEIJING, 1, 1);
		StockPO p2 = new StockPO(City.NANJING, "0000000000002", "00010000000110", "01-03", City.BEIJING, 1, 2);
		StockPO p3 = new StockPO(City.NANJING, "0000000000003", "00010000000110", "01-04", City.BEIJING, 1, 3);
		StockData s;
		try {
			s = new StockData();
			s.add(p1);
			s.add(p2);
			s.add(p3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
