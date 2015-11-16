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
public class checkoutstocknum {

	@Test
	public void test() {
		Stock stock = new Stock();
		assertEquals(30, stock.checkOutStock("20150101", "20150110"));
	}

}
