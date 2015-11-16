package blservice.receiptblservice;

import java.util.ArrayList;

import VO.*;

public interface InStockRepblService extends ReceiptblService{
	
	public InStockRepVO update (String num, String listNum, int area, int loc);
	
	public String submit(String num, String date, int area, int loc, ArrayList<String> goods);
	
}
