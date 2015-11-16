/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;


/**
 * @author G
 *
 */
public class MockStockList extends StockList{
	ArrayList<StockListItem> stocklist = new ArrayList<StockListItem>();
	
	public void addStockListItem(StockListItem i) {
		stocklist.add(i);
	}
	
	public ArrayList<StockListItem> getPresentStockList() {
		//TODO
		return stocklist;
	}
}
