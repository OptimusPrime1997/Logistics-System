package dataservice.receiptdataservice;

import java.util.ArrayList;

public interface InStockRepDataService extends ReceiptDataService{
	public String update(String num, String listNum, int area, int loc);
	
	public String submit(String num, String date, int area, int loc, ArrayList<String> goods);
}
