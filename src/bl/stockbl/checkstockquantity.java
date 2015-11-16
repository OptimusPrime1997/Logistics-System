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
public class checkstockquantity {

	@Test
	public void test() {
		Stock stock = new Stock();
		assertEquals(90, stock.checkStockQuantity("20150101", "20150110"));
	}

}
