/**
 * 
 */
package bl.stockbl;

import blservice.stockblservice.StockNumBLService;

/**
 * @author G
 *
 */
public class StockNum implements StockNumBLService{
	private int initialStockNum;
	//初始化当前城市库存数量
	public void initial(int initialNum) {
		
	}
	
	//由当前城市，得到初始库存数量
	
	public int getInitialStockNum() {
		//TODO
	
		return initialStockNum;
	}
	

}
