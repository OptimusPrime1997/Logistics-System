/**
 * 
 */
package bl.stockbl;

import util.enumData.ResultMessage;
import blservice.stockblservice.StockNumBLService;

/**
 * @author G
 *
 */
public class StockNum implements StockNumBLService{
	
	private int number;
	/**
	 * 初始化当前城市库存数量
	 */
	public ResultMessage initial(int initialNum) {
		//TODO
		return ResultMessage.SUCCESS;
	}
	
	/**
	 * 由当前城市，得到初始库存数量
	 * @return
	 */
	public int getInitialStockNum() {
		//TODO
	
		return number;
	}
	

}
