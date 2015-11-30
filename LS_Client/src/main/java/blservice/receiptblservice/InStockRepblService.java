package blservice.receiptblservice;

import VO.*;

public interface InStockRepblService extends ReceiptblService{
	
	public InStockRepVO update (String num, String listNum, int area, int loc);
	
	public int[] getTwoPosition(String destination);
	
}
