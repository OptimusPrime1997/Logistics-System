/**
 * 
 */
package bl.stockbl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author G
 *
 */
public class getpresentstocknum {

	@Test
	public void test() {
		
		
		Stock stock = new Stock();
		
		assertEquals(102,stock.checkPresentStockQuantity());
		
		
		
	}

}
