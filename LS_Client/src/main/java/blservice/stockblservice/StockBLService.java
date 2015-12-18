/**
 * 与界面进行库存管理的接口，有库存查看（某段时间内入库数量，某段时间内出库数量，某段时间内库存数量，
 * 									现有库存数量）
 * 库存
 */
package blservice.stockblservice;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.StockVO;
import VO.Receipt.InStockRepVO;
import VO.Receipt.OutStockRepVO;

/**
 * @author G
 *
 */
public interface StockBLService {
	

	
	
	/**
	 * 界面提供起始日期和终止日期，系统返回该仓库此段时间内的入库数量，出库数量
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws RemoteException 
	 */
	public String checkStock(String startMonth, String startDay, String endMonth, String endDay) throws RemoteException;
	
	
	
	/**
	 * 系统提供该仓库当前库存数量
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public int checkPresentStockQuantity() throws ClassNotFoundException, NotBoundException, IOException;
	
	/**
	 * 系统提供该仓库每个区当前的库存数量
	 * @param block
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public int checkPresentStockQuantity(int block) throws ClassNotFoundException, NotBoundException, IOException;
	
	/**
	 * @return
	 * @throws IOException 
	 * @throws NotBoundException 
	 * @throws ClassNotFoundException 
	 */
	public ArrayList<StockVO> showToday() throws ClassNotFoundException, NotBoundException, IOException; 
	
	public ResultMessage exportExcel() throws ClassNotFoundException, NotBoundException, IOException;
	
	

}