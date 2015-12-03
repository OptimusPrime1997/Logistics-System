/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import VO.ReceiptVO.OutStockRepVO;
import bl.receiptbl.OutStockRepbl.OutStockRepbl;

/**
 * @author G
 *
 */
public class MockOutStockRep extends OutStockRepbl{
	public ArrayList<OutStockRepVO> getbyDate(String date) {
		OutStockRepVO vo1 = new OutStockRepVO(date, date, null, null, date, date, null);
		OutStockRepVO vo2 = new OutStockRepVO(date, date, null, null, date, date, null);
		OutStockRepVO vo3 = new OutStockRepVO(date, date, null, null, date, date, null);
		
		
		ArrayList<OutStockRepVO> arr = new ArrayList<OutStockRepVO>();
		
		arr.add(vo1);
		arr.add(vo2);
		arr.add(vo3);
		
		return arr;
	}
}
