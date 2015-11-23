package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceiptPO;
import util.enumData.ResultMessage;

public interface ReceiptDataService extends Serializable{
	
	public ResultMessage submit(ReceiptPO po);
	
	public ResultMessage save(ReceiptPO po);
	
	public ArrayList<ReceiptPO> getAllRep();
	
	public ArrayList<ReceiptPO> getRepByDate(String date);
	
	public ReceiptPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
	
	public String createNum();
}
