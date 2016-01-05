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
import PO.StockDivisionPO;
import PO.StockPO;
import PO.Receipt.InStockPO;
import PO.Receipt.InStockRepPO;
import PO.Receipt.OutStockRepPO;
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


public static void main(String[] args) throws RemoteException{
	InStockPO inStockPO = new InStockPO("0250000002", 3+"", 1+"");
	ArrayList<InStockPO> inStockPOs = new ArrayList<InStockPO>();
	inStockPOs.add(inStockPO);
	InStockRepPO inStockRepPO = new InStockRepPO("0200002016010520006", "2016-01-05", inStockPOs);
	City city = City.GUANGZHOU;
	StockDivisionData stockDivisionData = new StockDivisionData();
	stockDivisionData.update(inStockRepPO, city);
}
	
	@Override
	public ResultMessage update(InStockRepPO po, City cityNum) throws RemoteException {
		ResultMessage rm = ResultMessage.SUCCESS;
	
		System.out.println("division "+cityNum.toString());
		ArrayList<InStockPO> list = po.getInStockPOs();
		
		for(InStockPO inpo : list) {
			int block = Integer.parseInt(inpo.getArea());
			int place = Integer.parseInt(inpo.getLoc());
			City desCity = FromIntToCity.toCity(block);
			rm = add(new StockDivisionPO(cityNum, inpo.getOrder(), desCity, block, place));
			
		}
		System.out.println(rm);
		if (rm == ResultMessage.SUCCESS) {
			System.out.println("division ADD success");
		}
		return rm;
		
	}

	
	/**
	 * @param stockDivisionPO
	 * @return
	 */
	public ResultMessage add(StockDivisionPO po)throws RemoteException {		

		ArrayList<Object> list ;
		try {
			list = du.getAll(filename);
		
			if(list != null) {
				
				for(Object o:list){
					StockDivisionPO p = (StockDivisionPO)o;
					
					if(p.getCityNum()==po.getCityNum()&&p.getBlock()==po.getBlock()&&p.getPlace()==po.getPlace()){
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
	public ResultMessage delete(String goods) throws RemoteException{
		boolean isFound = false;
		ArrayList<Object> list ;
		try {
			list = du.getAll(filename);
			if (list != null) {
				for(int i = 0;i < list.size();++i) {
					StockDivisionPO po = (StockDivisionPO)list.get(i);
					String s=po.getListNum();
					//TODO 为什么匹配不上
					System.out.println(s.equals(goods));
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


	/**
	 * 得到本城市仓库所有的货物
	 */
	@Override
	public ArrayList<StockDivisionPO> getStockDivision(City cityNum) throws IOException, RemoteException {
	 
		ArrayList<StockDivisionPO> list = new ArrayList<StockDivisionPO>();
		ArrayList<Object> listo = new ArrayList<Object>();
		try {
			listo = du.getAll(filename);
			if(listo!=null){
				for(Object o:listo) {
					StockDivisionPO po = (StockDivisionPO) o;
					//筛选出本城市仓库
					if(po.getCityNum().equals(cityNum)){
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
	 * @see dataservice.stockdataservice.StockDivisionDataService#find(int, int)
	 */
	@Override
	public StockDivisionPO find(int block, int place) throws ClassNotFoundException, IOException,RemoteException {
		
		ArrayList<Object> listo = du.getAll(filename);
		
		for(Object o:listo) {
			StockDivisionPO po = (StockDivisionPO) o;
			
			if (po.getBlock() == block && po.getPlace() == place) {
				return po;
			}
		}
		
		return null;
	}




//	public static void main(String[] args) {
//		StockDivisionData s;
//		try {
//			s = new StockDivisionData();
//			s.add(new StockDivisionPO(City.NANJING, "0000000101", City.BEIJING, 1, 1));
//			s.add(new StockDivisionPO(City.NANJING, "0000000102", City.BEIJING, 1, 2));
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	
	



}
