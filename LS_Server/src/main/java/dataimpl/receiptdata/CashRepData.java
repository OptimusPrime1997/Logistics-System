package dataimpl.receiptdata;

import java.io.IOException;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.CashRepDataService;
import datautil.DataUtility;

public class CashRepData implements CashRepDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7389892639283029412L;
	
	private DataUtility util = new DataUtility();
	
	public String getAdd() {
		return "data/ReceiptSaveData/CashRepSave.txt";
	}
	
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException{
		ArrayList<Object> objects = util.getAll(getAdd());
		if (objects == null)
			return null;
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		for(Object object : objects){
			ReceiptPO receiptPO = (ReceiptPO)object;
			if(receiptPO.getDate().equals(date))
				receiptPOs.add(receiptPO);
		}
		return receiptPOs;
	}
	
	public ArrayList<ReceiptPO> getAllRep() throws ClassNotFoundException, IOException{
		ArrayList<Object> objects = util.getAll(getAdd());
		if (objects == null)
			return null;
		ArrayList<ReceiptPO> receiptPOs = new ArrayList<ReceiptPO>();
		for(int i = 0;i < objects.size();i++){
			receiptPOs.add((ReceiptPO)objects.get(i));
		}
		return receiptPOs;
		
	}
}