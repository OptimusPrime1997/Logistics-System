package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.Receipt.ReceiptPO;
import util.enumData.Rep;

public interface ReceiptDataService extends Remote,Serializable{
	
	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	public ArrayList<ReceiptPO> getAllRep(Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException;
	
	public String createNum(String date, Rep rep, String office) throws ClassNotFoundException, IOException, RemoteException;
	
	public void clearSubmit(Rep rep, String office) throws IOException, ClassNotFoundException;
	
	public void clearSave(Rep rep, String office) throws IOException, ClassNotFoundException;
	
	public ReceiptPO getSubmitRep(Rep rep, String office) throws ClassNotFoundException, IOException;
	
	public ArrayList<ReceiptPO> forCheck(Rep rep) throws ClassNotFoundException, IOException;

	void submitSave(ReceiptPO po, Rep rep) throws ClassNotFoundException, IOException;
	
}