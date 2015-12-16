package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;

public interface OutStockRepDataService extends Remote,Serializable{

	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException;
}
