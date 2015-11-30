
package bl.receiptbl.InStockRepbl;

import java.util.ArrayList;
import VO.InStockRepVO;
import VO.ReceiptVO;
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

	public String createNum(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int n) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
		
	}

	public InStockRepVO getRepByNum(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public void submit(ReceiptVO vo) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<InStockRepVO> getRepBydate(String date){
		//TODO
		return null;
	}
}
