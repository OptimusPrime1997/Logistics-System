package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.GetRepPO;
import util.enumData.ResultMessage;

public interface GetRepDataService extends Serializable{
	public ResultMessage submit(GetRepPO po);
	
	public ResultMessage save(GetRepPO po);
	
	public ArrayList<GetRepPO> getAllRep();
	
	public ArrayList<GetRepPO> getRepByDate(String date);
	
	public GetRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
