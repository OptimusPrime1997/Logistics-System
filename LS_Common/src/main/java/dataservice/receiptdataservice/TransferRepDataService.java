package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.TransferRepPO;
import util.enumData.ResultMessage;

public interface TransferRepDataService extends Serializable {
	public ResultMessage submit(TransferRepPO po);
	
	public ResultMessage save(TransferRepPO po);
	
	public ArrayList<TransferRepPO> getAllRep();
	
	public ArrayList<TransferRepPO> getRepByDate(String date);
	
	public TransferRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
