/**
 * 与界面进行库存管理的接口，有库存查看（某段时间内入库数量，某段时间内出库数量，某段时间内库存数量，
 * 									现有库存数量）
 * 库存
 */
package blservice.stockblservice;

import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.InStockRepVO;
import VO.OutStockRepVO;
import VO.StockVO;

/**
 * @author G
 *
 */
public interface StockBLService {
	
	//TODO
//	
	public InStockRepVO toWriteInStockRep();
	public OutStockRepVO toWriteOutStockRep();
	
	
	
	/**
	 * 界面提供起始日期和终止日期，系统返回该仓库此段时间内的入库数量，出库数量
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public String checkStock(String startMonth, String startDay, String endMonth, String endDay);
	
	
	
	/**
	 * 系统提供该仓库当前库存数量
	 * @return
	 */
	public int checkPresentStockQuantity();
	
	/**
	 * 系统提供该仓库当前库存的所有已存储的Stock信息
	 * @return
	 */
	public ArrayList<StockVO> show(); 
	
	
	

}