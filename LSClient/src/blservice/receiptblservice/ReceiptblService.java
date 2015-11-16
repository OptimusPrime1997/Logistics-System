package blservice.receiptblservice;

import VO.*;
import util.enumData.Rep;

public interface ReceiptblService {
	public String delete (Rep rep, int n);
	
	public String delete (Rep rep, String num);
	
	public ReceiptVO show (Rep rep);
	
	public ReceiptVO find (Rep rep, String num);

	void addLog(String operationName, String operatorID, String time);

}
