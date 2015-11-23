package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.OutStockRepPO;
import util.enumData.ResultMessage;

public interface OutStockRepDataService extends Serializable{
	public ResultMessage submit(OutStockRepPO po);
	
	public ResultMessage save(OutStockRepPO po);
	
	public ArrayList<OutStockRepPO> getAllRep();
	
	public ArrayList<OutStockRepPO> getRepByDate(String date);
	
	public OutStockRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
