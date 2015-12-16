package dataimpl.receiptdata;

import java.io.IOException;
import java.util.ArrayList;

import PO.Receipt.InStockRepPO;
import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.InStockRepDataService;
import datautil.DataUtility;

public class InStockRepData implements InStockRepDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -467935443935015056L;
	
	private DataUtility util = new DataUtility();
	
	private String getAdd(){
		return "data/ReceiptSubmitData/InStockRepSubmit.txt";
	}

	@Override
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Object> objects = util.getAll(getAdd());
		ArrayList<ReceiptPO> inStockRepPOs = new ArrayList<ReceiptPO>();
		if (objects == null)
			return null;
		for(Object object : objects){
			inStockRepPOs.add((ReceiptPO)object);
		}
		return inStockRepPOs;
	}


}
