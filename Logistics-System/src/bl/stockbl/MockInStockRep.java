/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import VO.InStockRepVO;
import bl.receiptbl.InStockRepblImpl;

/**
 * @author G
 *
 */
public class MockInStockRep extends InStockRepblImpl {
	
	
	public ArrayList<InStockRepVO> getByDate (String date) {
		
		ArrayList<InStockRepVO> instocks = new ArrayList<InStockRepVO>();
		
		InStockRepVO vo1 = new InStockRepVO();
		InStockRepVO vo2 = new InStockRepVO();
		
		instocks.add(vo1);
		instocks.add(vo2);
		
		
		
		return instocks;
		
	}
}
