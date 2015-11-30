package dataservice.receiptdataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import PO.ReceiptPO;
import util.enumData.Rep;

public interface ReceiptDataService extends Remote,Serializable{
	
	public void submit(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	public void save(ReceiptPO po, Rep rep) throws IOException, RemoteException;
	
	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws ClassNotFoundException, IOException, RemoteException;
	
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep) throws ClassNotFoundException, IOException, RemoteException;
	
	public ReceiptPO getRepByNum(String num, Rep rep) throws IOException, ClassNotFoundException, RemoteException;
	
	public void delete(int n, Rep rep) throws ClassNotFoundException, IOException, RemoteException;
	
	public void delete(String num, Rep rep) throws ClassNotFoundException, IOException, RemoteException;
	
	public String createNum(String date, Rep rep) throws ClassNotFoundException, IOException, RemoteException;
}
