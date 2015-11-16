package bl.receiptbl.CashRepbl;

import RMI.ReceiptClient;

public class MockCourierName {
	public String getCourierName(String courierNum){
		return (new ReceiptClient()).go();
	}
}
