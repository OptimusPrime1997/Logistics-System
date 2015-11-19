package dataimpl.receiptdata;

import dataservice.receiptdataservice.InStockRepDataService;
import java.util.ArrayList;
import PO.InStockRepPO;

public class InStockRepData extends ReceiptData implements InStockRepDataService{

	@Override
	public String update(String num, String listNum, int area, int loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String submit(String num, String date, int area, int loc, ArrayList<String> goods) {
		repArray.add(new InStockRepPO(num, date, area, loc, goods));
		return null;
	}

}
