/**
 * 
 */
package bl.stockbl;

import java.util.ArrayList;

import VO.InStockRepVO;
import ui.receiptui.InStockRep;

/**
 * @author G
 *
 */
public class MockInStockRep  extends InStockRep {
	
	
	public ArrayList<InStockRepVO> getByDate (String date) {
		
		InStockRepVO vo1 = new InStockRepVO();
		InStockRepVO vo2 = new InStockRepVO();
		
		ArrayList<InStockRepVO> arr = new ArrayList<InStockRepVO>();
		
		arr.add(vo1);
		arr.add(vo2);
		
		return arr;
		
	}
	

}
