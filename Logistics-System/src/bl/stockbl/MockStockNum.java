/**
 * 
 */
package bl.stockbl;

/**
 * @author G
 *
 */
public class MockStockNum extends StockNum{
	int initialStockNum;
	
	public void initial(int initialNum) {
		initialStockNum = initialNum;
		System.out.println("  i am ini  "+initialStockNum);
	}
	
	//由当前城市，得到初始库存数量
	
	public int getInitialStockNum() {
		//TODO
		System.out.println("  i will return  "+ initialStockNum);
		return initialStockNum;
	}
}
