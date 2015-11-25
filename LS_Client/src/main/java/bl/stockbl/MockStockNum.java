/**
 * 
 */
package bl.stockbl;

import util.enumData.ResultMessage;

/**
 * @author G
 *
 */
public class MockStockNum extends StockNum{
	int initialStockNum;
	
	public ResultMessage initial(int initialNum) {
		initialStockNum = initialNum;
		System.out.println("  i am ini  "+initialStockNum);
		return ResultMessage.SUCCESS;
	}
	
	//由当前城市，得到初始库存数量
	
	public int getInitialStockNum() {
		//TODO
		System.out.println("  i will return  "+ initialStockNum);
		return initialStockNum;
	}
}
