package RMIClient.Receipt;

import java.rmi.Naming;
import PO.ReceiptPO;
import ReceiptRMI.ReceiptRemote;
import util.enumData.ResultMessage;

public class ReceiptClient {
	
	public ResultMessage submit(ReceiptPO po){
		try {
			ReceiptRemote service = (ReceiptRemote)Naming.lookup("rmi://127.0.0.1:1099/Hello"); 
			return service.submit(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}