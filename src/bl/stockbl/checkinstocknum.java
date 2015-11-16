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
public class checkinstocknum {

	@Test
	public void test() {
		Stock stock = new Stock();
		assertEquals(20, stock.checkInStock("20150101", "20150110"));
	}

}
