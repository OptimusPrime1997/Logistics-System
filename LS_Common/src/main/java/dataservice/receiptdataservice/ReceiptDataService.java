package dataservice.receiptdataservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceiptPO;
import util.enumData.Rep;
import util.enumData.ResultMessage;

public interface ReceiptDataService extends Serializable{
	
	public ResultMessage submit(ReceiptPO po, Rep rep) throws IOException;
	
	public ResultMessage save(ReceiptPO po, Rep rep) throws IOException;
	
	public ArrayList<ReceiptPO> getAllRep(Rep rep) throws ClassNotFoundException, IOException;
	
	public ArrayList<ReceiptPO> getRepByDate(String date, Rep rep) throws ClassNotFoundException, IOException;
	
	public ReceiptPO getRepByNum(String num, Rep rep) throws FileNotFoundException, IOException, ClassNotFoundException;
	
	public ResultMessage delete(int n, Rep rep) throws ClassNotFoundException, IOException;
	
	public ResultMessage delete(String num, Rep rep) throws ClassNotFoundException, IOException;
	
	public String createNum(String date, Rep rep) throws ClassNotFoundException, IOException;
}
