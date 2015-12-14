package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.ReceiptPO.PayRepPO;

public interface PayRepDataService extends Remote,Serializable{
	
	public PayRepPO getSubmitPayRep() throws ClassNotFoundException, IOException;
	
	public void clearPaySubmit() throws IOException;
	
	public ArrayList<PayRepPO> getAllPayRep() throws ClassNotFoundException, IOException;
}	
