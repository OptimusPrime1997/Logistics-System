package dataservice.receiptdataservice;

import java.io.Serializable;
import java.util.ArrayList;

import PO.ReceptionRepPO;
import util.enumData.ResultMessage;

public interface ReceptionRepDataService extends Serializable{
	public ResultMessage submit(ReceptionRepPO po);
	
	public ResultMessage save(ReceptionRepPO po);
	
	public ArrayList<ReceptionRepPO> getAllRep();
	
	public ArrayList<ReceptionRepPO> getRepByDate(String date);
	
	public ReceptionRepPO getRepByNum(String num);
	
	public ResultMessage delete(int n);
	
	public ResultMessage delete(String num);
}
