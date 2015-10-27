package blservice.receiptblservice;

import VO.*;
import state.Rep;

public interface ReceiptblService {
	public String delete (Rep rep, int n);
	
	public String delete (Rep rep, String num);
	
	public ReceiptVO show (Rep rep);
	
	public ReceiptVO find (Rep rep, String num);
	
	public String CheckFormat (Rep rep, String text);

}
