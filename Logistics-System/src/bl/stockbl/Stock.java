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
public class Stock {
	private String cityNum;
	private String listNum;
	private String inStockRepNum;
	private String inStockDate;
	private String destination;
	private int block;
	private int place;
	
	public int checkInStock(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int checkOutStock(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int checkStockQuantity(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int checkPresentStockQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ArrayList<StockVO> show() {
		// TODO Auto-generated method stub
		return null;
	}

}
