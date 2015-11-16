package RMI;

import java.rmi.Naming;
import ReceiptRMI.ReceiptRemote;

public class ReceiptClient {
	
	public String go(){
		String s = null;
		try{
			ReceiptRemote service = (ReceiptRemote)Naming.lookup("rmi://127.0.0.1:1099/Hello"); 
			s = service.getCourier();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return s;
	}
}