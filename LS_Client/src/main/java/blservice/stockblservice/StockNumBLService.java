/**
 * 初始库存数量的初始化
 */
package blservice.stockblservice;

import util.enumData.ResultMessage;

/**
 * @author G
 *
 */
public interface StockNumBLService {
	/**
	 * 界面提供初始化库存数量，系统持久化该仓库库存初始数量
	 * @param initialNum
	 */
	public ResultMessage initial(String initialNum);
}
