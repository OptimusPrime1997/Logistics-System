package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;

public interface CashRepDataService extends Remote,Serializable{
	public ArrayList<ReceiptPO> getAllRepByDate(String date) throws ClassNotFoundException, IOException;
	
	public ArrayList<ReceiptPO> getAllRep() throws ClassNotFoundException, IOException;
}