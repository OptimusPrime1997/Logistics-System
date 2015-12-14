package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.ReceiptPO.ReceiptPO;

public interface InStockRepDataService extends Remote,Serializable{
	
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException;
	
}
