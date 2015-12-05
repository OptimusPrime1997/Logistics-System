/**
 * 支持界面的手动分区以及提供可用区位
 */
package blservice.stockblservice;

import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.StockDivisionVO;

/**
 * @author G
 *
 */
public interface StockDivisionBLService {
	
	/**
	 * 界面提供旧的区号和位号，新的区号和位号，系统将旧的区位号变成新的区位号
	 * @param oldBlock
	 * @param oldPlace
	 * @param newBlock
	 * @param newPlace
	 */
	public ResultMessage modifyDivision(int oldDivision, int oldBlock, int oldPlace,int newDivision, int newBlock, int newPlace);
	
	/**
	 * 界面提供目的地，系统提供该仓库可用的区号和位号
	 * @param destination
	 * @return
	 */
	public ArrayList<StockDivisionVO> getBlock(String destination);
}
