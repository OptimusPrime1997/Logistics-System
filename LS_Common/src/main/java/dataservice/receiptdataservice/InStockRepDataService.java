package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.InStockRepPO;
import util.enumData.ResultMessage;

public interface InStockRepDataService extends Serializable{
	public ResultMessage update(String num, String listNum, int area, int loc);
	
	public ResultMessage submit(InStockRepPO po);
	
	public ResultMessage save(InStockRepPO po);
	
	public ArrayList<InStockRepPO> getAllRep();
	
	public ArrayList<InStockRepPO> getRepByDate(String date);
	
	public InStockRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
