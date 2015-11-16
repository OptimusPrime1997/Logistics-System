
package bl.receiptbl;

import java.util.ArrayList;
import VO.InStockRepVO;
import bl.stockbl.StockDivisionbl;
import blservice.receiptblservice.InStockRepblService;


public class InStockRepblImpl extends ReceiptblImpl implements InStockRepblService{
	
	@Override
	public InStockRepVO update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public InStockRepVO getByList (String listNum){
		return null;
		
	}
	
	public ArrayList<InStockRepVO> getByDate (String date) {
		return null;
		
	}
	
	public int[] getTwoPosition(String destination){
		StockDivisionbl stock = new StockDivisionbl();
		stock.getBlock(destination);
		return null;
	}

	@Override
	public String submit(String num, String date, int area, int loc, ArrayList<String> goods) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
