package RMIClient.Receipt;

import java.rmi.Naming;
import java.util.ArrayList;

import PO.CashRepPO;
import ReceiptRMI.ReceiptRemote;

public class CashRepRMI {
	public ArrayList<CashRepPO> getCashRepPO(){
		try {
			ReceiptRemote service = (ReceiptRemote)Naming.lookup("rmi://127.0.0.1:1099/Hello"); 
			return service.getCashRepPO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
