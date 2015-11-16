package bl.formbl;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ProfitFormTEST {
	@Test
	public void test(){
		ProfitFormbl pform = new ProfitFormbl();
		assertEquals((int)51300,(int)pform.show().totalOut);
		assertEquals((int)4000, (int)pform.show().totalIn);
		assertEquals((int)-47300, (int)pform.show().totalProfit);
	}

}
