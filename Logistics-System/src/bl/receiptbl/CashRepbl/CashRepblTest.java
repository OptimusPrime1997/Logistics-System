package bl.receiptbl.CashRepbl;

import static org.junit.Assert.*;
import bl.receiptbl.CashRepbl.CashRepController;
import org.junit.Test;

public class CashRepblTest {
	CashRepController test = new CashRepController();

	@Test
	public void test() {
		assertEquals("罗总", test.getCashRepbl().getCourierName("1010011000"));
	}

}
