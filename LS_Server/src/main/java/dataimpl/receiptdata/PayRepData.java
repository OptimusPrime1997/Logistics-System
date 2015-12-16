package dataimpl.receiptdata;

import java.io.IOException;
import java.util.ArrayList;

import PO.Receipt.PayRepPO;
import PO.Receipt.ReceiptPO;
import dataservice.receiptdataservice.PayRepDataService;
import datautil.DataUtility;

public class PayRepData implements PayRepDataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6098610579749335008L;
	
	private DataUtility util = new DataUtility();
	
	public String getAdd() {
		return "data/ReceiptSubmitData/PayRepSubmit.txt";
	}

	public PayRepPO getSubmitPayRep() throws ClassNotFoundException, IOException{
		ArrayList<Object> objects = util.getAll(getAdd());
		if (objects == null)
			return null;
		ReceiptPO receiptPO = (ReceiptPO)objects.get(0);
		return (PayRepPO)receiptPO;
	}
	
	public void clearPaySubmit() throws IOException{
		util.clear(getAdd());
	}
	
	public ArrayList<PayRepPO> getAllPayRep() throws ClassNotFoundException, IOException{
		ArrayList<PayRepPO> payRepPOs = new ArrayList<PayRepPO>();
		ArrayList<Object> objects = util.getAll(getAdd());
		if (objects == null)
			return null;
		for (Object object : objects) {
			PayRepPO payRepPO = (PayRepPO) object;
			payRepPOs.add(payRepPO);
		}
		return payRepPOs;
	}
	
}
