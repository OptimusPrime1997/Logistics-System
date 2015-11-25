/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import util.enumData.ResultMessage;
import VO.InStockRepVO;
import VO.OutStockRepVO;
import VO.StockVO;
import blservice.stockblservice.StockBLService;

/**
 * @author G
 *
 */
public class StockController implements StockBLService{

	private Stock stock;
	public int checkInStock(String startDate, String endDate) {
		
		return stock.checkInStock(startDate, endDate);
	}

	public int checkOutStock(String startDate, String endDate) {
		
		return stock.checkOutStock(startDate, endDate);
	}
	
	public int checkStockQuantity(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return stock.checkStockQuantity(startDate, endDate);
	}

	
	public int checkPresentStockQuantity() {
		// TODO Auto-generated method stub
		return stock.checkPresentStockQuantity();
	}
	
	public ArrayList<StockVO> show() {
		// TODO Auto-generated method stub
		return stock.show();
	}

	
	@Override
	public InStockRepVO toWriteInStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public OutStockRepVO toWriteOutStockRep() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResultMessage initialStockNum(int num) {
		return stock.initialStockNum(num);
		
	}

}
