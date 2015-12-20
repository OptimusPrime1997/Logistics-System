package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;

public interface TransferRepDataService extends Remote,Serializable {

	public ArrayList<ReceiptPO> getMonthRep(String date) throws ClassNotFoundException, IOException;
}
