
package bl.receiptbl.InStockRepbl;

import java.util.ArrayList;
import VO.InStockRepVO;
import bl.receiptbl.Receiptbl.ReceiptblController;
import bl.stockbl.StockDivisionbl;

public class InStockRepbl{
	
	public InStockRepVO update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int[] getTwoPosition(String destination){
		StockDivisionbl stock = new StockDivisionbl();
		stock.getBlock(destination);
		return null;
	}

	
	public ArrayList<InStockRepVO> getRepBydate(String date){
		//TODO
		return null;
	}
}
