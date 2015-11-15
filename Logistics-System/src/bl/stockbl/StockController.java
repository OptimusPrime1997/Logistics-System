/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import VO.StockVO;
import blservice.stockblservice.StockBLService;

/**
 * @author G
 *
 */
public class StockController implements StockBLService{

	private Stock stock;
	@Override
	public int checkInStock(String startDate, String endDate) {
		
		return stock.checkInStock(startDate, endDate);
	}

	
	@Override
	public int checkOutStock(String startDate, String endDate) {
		
		return stock.checkOutStock(startDate, endDate);
	}

	
	@Override
	public int checkStockQuantity(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return stock.checkStockQuantity(startDate, endDate);
	}

	
	@Override
	public int checkPresentStockQuantity() {
		// TODO Auto-generated method stub
		return stock.checkPresentStockQuantity();
	}

	
	@Override
	public ArrayList<StockVO> show() {
		// TODO Auto-generated method stub
		return stock.show();
	}

}
