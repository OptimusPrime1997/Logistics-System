/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;


import VO.OutStockRepVO;
import bl.receiptbl.OutStockRepbl.OutStackRepbl;

/**
 * @author G
 *
 */
public class MockOutStockRep extends OutStackRepbl{
	public ArrayList<OutStockRepVO> getbyDate(String date) {
		OutStockRepVO vo1 = new OutStockRepVO();
		OutStockRepVO vo2 = new OutStockRepVO();
		OutStockRepVO vo3 = new OutStockRepVO();
		
		
		ArrayList<OutStockRepVO> arr = new ArrayList<OutStockRepVO>();
		
		arr.add(vo1);
		arr.add(vo2);
		arr.add(vo3);
		
		return arr;
	}
}
