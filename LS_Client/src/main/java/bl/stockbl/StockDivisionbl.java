/**
 * 
 */
package bl.stockbl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import util.CurrentCity;
import util.enumData.City;
import util.enumData.ResultMessage;
import PO.StockDivisionPO;
import PO.StockPO;
import PO.Receipt.InStockRepPO;
import PO.Receipt.OutStockRepPO;
import VO.StockDivisionVO;
import VO.Receipt.InStockRepVO;
import VO.Receipt.OutStockRepVO;
import bl.loginbl.Loginbl;
import blservice.stockblservice.StockDivisionBLService;
import dataservice.stockdataservice.StockDataService;
import dataservice.stockdataservice.StockDivisionDataService;

/**
 * @author G
 *
 */
public class StockDivisionbl implements StockDivisionBLService{

	
	private StockDivisionDataService getStockDivisionDataService() throws MalformedURLException, RemoteException, NotBoundException {
		StockDivisionDataService sd = (StockDivisionDataService) Naming.lookup("rmi://"+Loginbl.getIP()+":1099/stockDivision");
		return sd;
	}
	
	private StockDataService getStockDataService() throws MalformedURLException, RemoteException, NotBoundException {
		StockDataService s = (StockDataService) Naming.lookup("rmi://"+Loginbl.getIP()+":1099/stock");
		return s;
	}
	
	public ResultMessage update(InStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		InStockRepPO po = vo.toPO(vo);
		StockDivisionDataService sd = getStockDivisionDataService();
		City cityNum = CurrentCity.getCurrentCity();
		return sd.update(po, cityNum);
		
	}
	public ResultMessage update(OutStockRepVO vo) throws MalformedURLException, RemoteException, NotBoundException{
		OutStockRepPO po = vo.toPO(vo);
		StockDivisionDataService sd = getStockDivisionDataService();
		return sd.update(po);
	}
	
	public ResultMessage modifyDivision(int oldBlock, int oldPlace,int newBlock, int newPlace) throws NotBoundException, ClassNotFoundException, IOException {

		StockDataService s = getStockDataService();
		StockDivisionDataService sd = getStockDivisionDataService();
		StockDivisionPO po = sd.find(oldBlock, oldPlace);
		StockPO stockPO = s.find(oldBlock, oldPlace);
		City city = po.getCityNum();
		String listNum = po.getListNum();
		City des = po.getDestination();
		String repNum = stockPO.getInStockRepNum();
		String date = stockPO.getInStockDate();
		 
		ResultMessage rm1 = sd.delete(listNum);
		s.delete(listNum);
		s.add(new StockPO(city, listNum, repNum, date, des, newBlock, newPlace));
		ResultMessage rm2 = sd.add(new StockDivisionPO(city, listNum, des, newBlock, newPlace));
		
		if (rm1.equals(ResultMessage.SUCCESS)&&rm2.equals(ResultMessage.SUCCESS)) {
			return ResultMessage.SUCCESS;
		} else {
			return ResultMessage.FAILED;
		}
	}

	public ArrayList<StockDivisionVO> getBlock(City destination) throws NotBoundException, IOException {
		StockDivisionDataService sd = getStockDivisionDataService();
		City city = CurrentCity.getCurrentCity();
		ArrayList<StockDivisionVO> resultList = new ArrayList<StockDivisionVO>();
		ArrayList<StockDivisionPO> list = sd.getStockDivision(city);
		for (StockDivisionPO po : list) {
			//得到当前城市的当前区的所有block
			if (po.getDestination().equals(destination)) {
				resultList.add(new StockDivisionVO().poToVo(po));
			}
		}
		return resultList;
	}
	

	/**
	 * 判断此区位号是否已存在货物
	 * @param block
	 * @param place
	 * @return
	 * @throws NotBoundException
	 * @throws IOException 
	 */
	public boolean isPlaceAvailable(int block, int place) throws NotBoundException, IOException {
		
		boolean available = true;
		StockDivisionDataService sd = getStockDivisionDataService();
		
		City cityNum = CurrentCity.getCurrentCity();
		ArrayList<StockDivisionPO> list = sd.getStockDivision(cityNum);

		
		for(StockDivisionPO po:list) {
			if(po.getBlock()==block&&po.getPlace()==place) {
				available = false;
			}
		}
		
		return available;
	}
	
	/**
	 * 判断这个区位号是否在仓库中存在
	 * @param block
	 * @param place
	 * @return
	 * @throws MalformedURLException
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public boolean isExist(int block, int place) throws MalformedURLException, RemoteException, NotBoundException {
		boolean result = false;
		if(block<=8&&block>=1&&place>0&&place<=1000) {
			result = true;
		}
		
		return result;
	}
	
	
	/**
	 * 返回库存超过90%的区号们
	 * @param vo
	 * @return
	 * @throws NotBoundException 
	 * @throws IOException 
	 */
	public ArrayList<Integer> getOverBlock(InStockRepVO vo) throws NotBoundException, IOException{
		ArrayList<Integer> result = new ArrayList<Integer>();
		/**
		 *数组中存放每个区中货物的个数
		 */
		int [] block = new int[8];
		StockDivisionDataService sd = getStockDivisionDataService();
		City cityNum = CurrentCity.getCurrentCity();
		ArrayList<StockDivisionPO> list = sd.getStockDivision(cityNum);
		for(StockDivisionPO po:list) {
			block[po.getBlock()-1]+=block[po.getBlock()-1];
		}
		
		//找出库存报警的区号，并加入结果数组
		for(int i = 0; i < block.length; ++i) {
			if(block[i]>900) {
				result.add(i+1);
			}
		}
		
		return result;
	}


	/**
	 * @param des
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 */
	public StockDivisionVO getAvailableDivision(City des) throws NotBoundException, IOException {
		
		int block1 = des.toInt(des);
		int block2 = block1 + 1;
		
		for (int i = 1; i <= 1000; i++) {
			if (isPlaceAvailable(block1, i)) {
				return new StockDivisionVO(null, null, des, block1, i);
			}
			
			if (isPlaceAvailable(block2, i)) {
				return new StockDivisionVO(null, null, des, block2, i);
			}
			
		}
		
		return null;
	}
	
	public void delete(String listNum) throws RemoteException, MalformedURLException, NotBoundException{
		StockDivisionDataService sd = getStockDivisionDataService();
		sd.delete(listNum);
	}


	/* (non-Javadoc)
	 * @see blservice.stockblservice.StockDivisionBLService#getBlockByDivision(int)
	 */
	@Override
	public ArrayList<StockDivisionVO> getBlockByDivision(int block) throws NotBoundException, IOException {
		// TODO Auto-generated method stub
		StockDivisionDataService sd = getStockDivisionDataService();
		City city = CurrentCity.getCurrentCity();
		ArrayList<StockDivisionVO> resultList = new ArrayList<StockDivisionVO>();
		ArrayList<StockDivisionPO> list = sd.getStockDivision(city);
		for (StockDivisionPO po : list) {
			//得到当前城市的当前区的所有block
			if (po.getBlock() == block) {
				resultList.add(new StockDivisionVO().poToVo(po));
			}
		}
		return resultList;

	}

}
