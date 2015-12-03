/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import VO.ReceiptVO.InStockRepVO;
import bl.receiptbl.InStockRepbl.InStockRepbl;


/**
 * @author G
 *
 */
public class MockInStockRep  extends InStockRepbl {
	
	
	public ArrayList<InStockRepVO> getByDate (String date) {
		
		InStockRepVO vo1 = new InStockRepVO(date, date, 0, 0, null);
		InStockRepVO vo2 = new InStockRepVO(date, date, 0, 0, null);
		
		ArrayList<InStockRepVO> arr = new ArrayList<InStockRepVO>();
		
		arr.add(vo1);
		arr.add(vo2);
		
		return arr;
		
	}
	

}
